/*
 * I think it can work for CJK Users.
 * Lewis Lv lzlhero@gmail.com
 */

;(function($) {
if ($.fn.textbox) {
	return;
}

var replaceCJK = /[\u2E80-\u9FFF\uF92C-\uFFE5]/g,
	testCJK    = /[\u2E80-\u9FFF\uF92C-\uFFE5]/;

// jQuery doesn't support a is string judgement, so I made it by myself.
function isString(obj) {
	return typeof obj == "string" || Object.prototype.toString.call(obj) === "[object String]";
}

$.fn.textbox = function(settings) {
	var defaults = {
		maxLength: -1,
		onInput: null,
		cjk: false,
		wild: false
	};
	var opts = $.extend(defaults, settings);

	// This is the prefect get caret position function.
	// You can use it cross browsers.
	function getInsertPos(textbox) {
		var iPos = 0;
		if (textbox.selectionStart || textbox.selectionStart == "0") {
			iPos = textbox.selectionStart;
		}
		else if (document.selection) {
			textbox.focus();
			var range = document.selection.createRange();
			var rangeCopy = range.duplicate();
			rangeCopy.moveToElementText(textbox);
			while (range.compareEndPoints("StartToStart", rangeCopy) > 0) {
				range.moveStart("character", -1);
				iPos++;
			}
		}
		return iPos;
	}

	// This is the prefect set caret position function.
	// You can use it cross browsers.
	function setInsertPos(textbox, iPos) {
		textbox.focus();
		if (textbox.selectionStart || textbox.selectionStart == "0") {
			textbox.selectionStart = iPos;
			textbox.selectionEnd = iPos;
		}
		else if (document.selection) {
			var range = textbox.createTextRange();
			range.moveStart("character", iPos);
			range.collapse(true);
			range.select();
		}
	}

	// Used for IE to save last selection.
	function getSelection(el) {
		var start, end;
		if (el.selectionStart || el.selectionStart == "0") {
			start = el.selectionStart, end = el.selectionEnd;
		}
		else if (document.selection) {
			var normalizedValue, textInputRange, len, endRange;
			var range = document.selection.createRange();
			start = 0, end = 0;

			if (range && range.parentElement() == el) {
				len = el.value.length;

				normalizedValue = el.value.replace(/\r/g, "");
				textInputRange = el.createTextRange();
				textInputRange.moveToBookmark(range.getBookmark());
				endRange = el.createTextRange();
				endRange.collapse(false);
				if (textInputRange.compareEndPoints("StartToEnd", endRange) > -1) {
					start = end = len;
				} else {
					start = -textInputRange.moveStart("character", -len);
					start += normalizedValue.slice(0, start).split("\n").length - 1;
					if (textInputRange.compareEndPoints("EndToEnd", endRange) > -1) {
						end = len;
					} else {
						end = -textInputRange.moveEnd("character", -len);
						end += normalizedValue.slice(0, end).split("\n").length - 1;
					}
				}
			}
		}

		return {
			start: start,
			end: end
		};
	}

	// Used for IE to restore selection.
	function adjustOffsets(el, start, end) {
		if (start < 0) {
			start += el.value.length;
		}
		if (typeof end == "undefined") {
			end = start;
		}
		if (end < 0) {
			end += el.value.length;
		}
		return {start: start, end: end};
	}

	// Used for IE to restore selection.
	function offsetToRangeCharacterMove (el, offset) {
		return offset - (el.value.slice(0, offset).split("\r\n").length - 1);
	}

	function isGreateMaxLength(strValue, strDelete) {
		var maxLength = opts.cjk ? opts.maxLength * 2 : opts.maxLength;
		if (maxLength > 0) {
			var valueLength = (opts.cjk ? strValue.replace(replaceCJK, "lv") : strValue).replace(/\r/g, "").length;
			var deleteLength = (strDelete ? (opts.cjk ? strDelete.replace(replaceCJK, "lv") : strDelete).replace(/\r/g, "").length : 0);

			return valueLength - deleteLength > maxLength;
		}
		else {
			return false;
		}
	}

	function fixLength(textbox) {
		var maxLength = opts.cjk ? opts.maxLength * 2 : opts.maxLength;
		if (maxLength > 0) {
			var strValue = textbox.value.replace(/\r/g, "");
			if (isGreateMaxLength(strValue)) {
				if (opts.cjk) {
					for (var i = 0, index = 0; i < maxLength; index++) {
						if (testCJK.test(strValue.charAt(index))) {
							i += 2;
						}
						else {
							i += 1;
						}
					}
					maxLength = index;
				}

				textbox.value = strValue.substr(0, maxLength);
			}
		}
	}

	function inputHandler(event) {
		// truck extra input text
		var strValue = this.value.replace(/\r/g, "");
		if (!opts.wild && isGreateMaxLength(strValue)) {
			// remember the scroll top position.
			var scrollTop = this.scrollTop,
				insertPos = getInsertPos(this),
				deleteLength = 0;

			if (opts.cjk) {
				var overLength = strValue.replace(replaceCJK, "lv").length - opts.maxLength * 2;
				for (var i = 0; i < overLength; deleteLength++) {
					if (testCJK.test(strValue.charAt(insertPos - deleteLength - 1))) {
						i += 2;
					}
					else {
						i += 1;
					}
				}
			}
			else {
				deleteLength = strValue.length - opts.maxLength;
			}

			var iInsertToStartLength = insertPos - deleteLength;
			this.value = strValue.substr(0, iInsertToStartLength) + strValue.substr(insertPos);
			setInsertPos(this, iInsertToStartLength);

			// set back the scroll top position.
			this.scrollTop = scrollTop;
		}

		if ($.isFunction(opts.onInput)) {
			// callback for input handler
			opts.onInput.call(this, event, {
				maxLength: opts.maxLength,
				leftLength: getLeftLength(this)
			});
		}
	};

	function getSelectedText(textbox) {
		var strText = "";
		if (textbox.selectionStart || textbox.selectionStart == "0") {
			strText = textbox.value.substring(textbox.selectionStart, textbox.selectionEnd);
		}
		else {
			strText = document.selection.createRange().text;
		}
		return strText.replace(/\r/g, "");
	};

	function getLeftLength(textbox) {
		return opts.cjk ?
			Math.round((opts.maxLength * 2 - textbox.value.replace(/\r/g, "").replace(replaceCJK, "lv").length) / 2) :
			opts.maxLength - textbox.value.replace(/\r/g, "").length;
	};

	function bindEvents(textbox, opts) {
		function keyupHandler(event) {
			if (opts.maxLength < 0) {
				if ($.isFunction(opts.onInput)) {
					opts.onInput.call(this, event, {maxLength: opts.maxLength, leftLength: -1});
				}
			}
			else {
				inputHandler.call(this, event);
			}
		};

		function shortcutHandler(event) {
			var textarea = this;
			window.setTimeout(function() {
				inputHandler.call(textarea, event);
			}, 0);
		};

		function blurHandler(event) {
			if (!opts.wild) {
				fixLength(this);
			}
		};

		var $textbox = $(textbox).bind("keyup.textbox", keyupHandler);
		if (opts.maxLength >= 0) {
			$textbox
					.bind("paste.textbox cut.textbox", shortcutHandler)
					.bind("blur.textbox", blurHandler);

			blurHandler.call(textbox);
		}
	};

	this.maxLength = function(maxLength) {
		if (maxLength) {
			opts.maxLength = maxLength;
			return this.filter("textarea").each(function() {
				$(this).unbind(".textbox").data("textbox-opts", opts);
				bindEvents(this, opts);
			}).end();
		}
		else {
			return opts.maxLength;
		}
	};

	this.insertPos = function(value) {
		var $textbox = this.filter("textarea");

		if (typeof value == "undefined") {
			return $textbox.length ? getInsertPos($textbox[0]) : null;
		}
		else if ($textbox.length) {
			if (isString(value) && value.toLowerCase() == "start") {
				value = 0;
			}
			else if (isString(value) && value.toLowerCase() == "end") {
				value = $textbox[0].value.replace(/\r/g, "").length;
			}

			setInsertPos($textbox[0], 
					Math.min(Math.max(parseInt(value) || 0, 0), $textbox[0].value.replace(/\r/g, "").length));
		}

		return this;
	};

	this.input = function(callback) {
		if ($.isFunction(callback)) {
			opts.onInput = callback;
			return this.filter("textarea").each(function() {
				$(this).data("textbox-opts", opts);
			}).end();
		}

		return this;
	};

	this.fixLength = function() {
		return this.filter("textarea").each(function() {
			fixLength(this);
		}).end();
	};

	this.insertText = function(strText) {
		if (!strText) {
			return;
		}

		strText = strText.replace(/\r/g, "");
		return this.filter("textarea").each(function() {
			if (opts.wild || !isGreateMaxLength(this.value + strText, getSelectedText(this))) {
				if (this.selectionStart || this.selectionStart == "0") {
					var startPos = this.selectionStart;
					var endPos = this.selectionEnd;
					var scrollTop = this.scrollTop;

					this.value = this.value.substring(0, startPos) + 
								strText + this.value.substring(endPos, this.value.length);
					this.focus();

					var cPos = startPos + strText.length;
					this.selectionStart = cPos;
					this.selectionEnd = cPos;
					this.scrollTop = scrollTop;
				}
				else if (document.selection) {
					this.focus();

					// make a new text range
					var range = this.createTextRange();
					range.collapse(true);

					// restore last lost focused selection with above text range
					var lastSelection = $(this).data("lastSelection");
					if (!lastSelection) {
						lastSelection = {start: 0, end: 0};
					}
					var offsets = adjustOffsets(this, lastSelection.start, lastSelection.end);
					var startCharMove = offsetToRangeCharacterMove(this, offsets.start);
					if (offsets.start == offsets.end) {
						range.move("character", startCharMove);
					}
					else {
						range.moveEnd("character", offsetToRangeCharacterMove(this, offsets.end));
						range.moveStart("character", startCharMove);
					}

					// replace selection with "strText"
					range.text = strText;
					range.collapse(true);
					range.select();
				}

				// fired when insert text has finished
				if ($.isFunction(opts.onInput)) {
					opts.onInput.call(this, {type: "insert"}, {
						maxLength: opts.maxLength,
						leftLength: getLeftLength(this)
					});
				}
			}
		}).end();
	};

	return this.filter("textarea").each(function() {
		var $textbox = $(this);

		if (settings) {
			if ($textbox.data("textbox-opts")) {
				$textbox.unbind(".textbox").data("textbox-opts", opts);
				bindEvents(this, opts);
			}
			else {
				$textbox.data("textbox-opts", opts)
				.bind("beforedeactivate", function() {
					// for restoring textbox selection when doing "inserText" method in IE
					$(this).data("lastSelection", getSelection(this));
				});

				bindEvents(this, opts);
			}
		}
		else {
			if ($textbox.data("textbox-opts")) {
				opts = $textbox.data("textbox-opts");
			}
		}
	}).end();
};
})(jQuery);