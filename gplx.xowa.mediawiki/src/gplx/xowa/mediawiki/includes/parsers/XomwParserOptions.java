/*
XOWA: the XOWA Offline Wiki Application
Copyright (C) 2012-2017 gnosygnu@gmail.com

XOWA is licensed under the terms of the General Public License (GPL) Version 3,
or alternatively under the terms of the Apache License Version 2.0.

You may use XOWA according to either of these licenses as is most appropriate
for your project on a case-by-case basis.

The terms of each license can be found in the source code repository:

GPLv3 License: https://github.com/gnosygnu/xowa/blob/master/LICENSE-GPLv3.txt
Apache License: https://github.com/gnosygnu/xowa/blob/master/LICENSE-APACHE2.txt
*/
package gplx.xowa.mediawiki.includes.parsers; import gplx.*; import gplx.xowa.*; import gplx.xowa.mediawiki.*; import gplx.xowa.mediawiki.includes.*;
public class XomwParserOptions {
	public XomwParserOptions() {
		this.mThumbSize = 220;
	}
//		/**
//		* Interlanguage links are removed and returned in an array
//		*/
//		private $mInterwikiMagic;
//
//		/**
//		* Allow external images inline?
//		*/
//		private $mAllowExternalImages;
//
//		/**
//		* If not, any exception?
//		*/
//		private $mAllowExternalImagesFrom;
//
//		/**
//		* If not or it doesn't match, should we check an on-wiki whitelist?
//		*/
//		private $mEnableImageWhitelist;
//
//		/**
//		* Date format index
//		*/
//		private $mDateFormat = null;
//
//		/**
//		* Create "edit section" links?
//		*/
//		private $mEditSection = true;
//
//		/**
//		* Allow inclusion of special pages?
//		*/
//		private $mAllowSpecialInclusion;
//
//		/**
//		* Use tidy to cleanup output HTML?
//		*/
//		private $mTidy = false;
//
//		/**
//		* Which lang to call for PLURAL and GRAMMAR
//		*/
//		private $mInterfaceMessage = false;
//
//		/**
//		* Overrides $mInterfaceMessage with arbitrary language
//		*/
//		private $mTargetLanguage = null;
//
//		/**
//		* Maximum size of template expansions, in bytes
//		*/
//		private $mMaxIncludeSize;
//
//		/**
//		* Maximum number of nodes touched by PPFrame::expand()
//		*/
//		private $mMaxPPNodeCount;
//
//		/**
//		* Maximum number of nodes generated by Preprocessor::preprocessToObj()
//		*/
//		private $mMaxGeneratedPPNodeCount;
//
//		/**
//		* Maximum recursion depth in PPFrame::expand()
//		*/
//		private $mMaxPPExpandDepth;
//
//		/**
//		* Maximum recursion depth for templates within templates
//		*/
//		private $mMaxTemplateDepth;
//
//		/**
//		* Maximum number of calls per parse to expensive parser functions
//		*/
//		private $mExpensiveParserFunctionLimit;
//
//		/**
//		* Remove HTML comments. ONLY APPLIES TO PREPROCESS OPERATIONS
//		*/
//		private $mRemoveComments = true;
//
//		/**
//		* @var callable Callback for current revision fetching; first argument to call_user_func().
//		*/
//		private $mCurrentRevisionCallback =
//			[ 'Parser', 'statelessFetchRevision' ];
//
//		/**
//		* @var callable Callback for template fetching; first argument to call_user_func().
//		*/
//		private $mTemplateCallback =
//			[ 'Parser', 'statelessFetchTemplate' ];
//
//		/**
//		* @var callable|null Callback to generate a guess for {{REVISIONID}}
//		*/
//		private $mSpeculativeRevIdCallback;
//
//		/**
//		* Enable limit report in an HTML comment on output
//		*/
//		private $mEnableLimitReport = false;
//
//		/**
//		* Timestamp used for {{CURRENTDAY}} etc.
//		*/
//		private $mTimestamp;
//
//		/**
//		* Target attribute for external links
//		*/
//		private $mExternalLinkTarget;
//
//		/**
//		* Clean up signature texts?
//		* @see Parser::cleanSig
//		*/
//		private $mCleanSignatures;
//
//		/**
//		* Transform wiki markup when saving the page?
//		*/
//		private $mPreSaveTransform = true;
//
//		/**
//		* Whether content conversion should be disabled
//		*/
//		private $mDisableContentConversion;
//
//		/**
//		* Whether title conversion should be disabled
//		*/
//		private $mDisableTitleConversion;
//
//		/**
//		* Automatically number headings?
//		*/
//		private $mNumberHeadings;

	/**
	* Thumb size preferred by the user.
	*/
	private int mThumbSize;

//		/**
//		* Maximum article size of an article to be marked as "stub"
//		*/
//		private $mStubThreshold;
//
//		/**
//		* Language Object of the User language.
//		*/
//		private $mUserLang;
//
//		/**
//		* @var User
//		* Stored user Object
//		*/
//		private $mUser;
//
//		/**
//		* Parsing the page for a "preview" operation?
//		*/
//		private $mIsPreview = false;
//
//		/**
//		* Parsing the page for a "preview" operation on a single section?
//		*/
//		private $mIsSectionPreview = false;
//
//		/**
//		* Parsing the printable version of the page?
//		*/
//		private $mIsPrintable = false;
//
//		/**
//		* Extra key that should be present in the caching key.
//		*/
//		private $mExtraKey = '';
//
//		/**
//		* Are magic ISBN links enabled?
//		*/
//		private $mMagicISBNLinks = true;
//
//		/**
//		* Are magic PMID links enabled?
//		*/
//		private $mMagicPMIDLinks = true;
//
//		/**
//		* Are magic RFC links enabled?
//		*/
//		private $mMagicRFCLinks = true;
//
//		/**
//		* Function to be called when an option is accessed.
//		*/
//		private $onAccessCallback = null;
//
//		/**
//		* If the page being parsed is a redirect, this should hold the redirect
//		* target.
//		* @var Title|null
//		*/
//		private $redirectTarget = null;
//
//		public function getInterwikiMagic() {
//			return this.mInterwikiMagic;
//		}
//
//		public function getAllowExternalImages() {
//			return this.mAllowExternalImages;
//		}
//
//		public function getAllowExternalImagesFrom() {
//			return this.mAllowExternalImagesFrom;
//		}
//
//		public function getEnableImageWhitelist() {
//			return this.mEnableImageWhitelist;
//		}
//
//		public function getEditSection() {
//			return this.mEditSection;
//		}
//
//		public function getNumberHeadings() {
//			this.optionUsed( 'numberheadings' );
//
//			return this.mNumberHeadings;
//		}
//
//		public function getAllowSpecialInclusion() {
//			return this.mAllowSpecialInclusion;
//		}
//
//		public function getTidy() {
//			return this.mTidy;
//		}
//
//		public function getInterfaceMessage() {
//			return this.mInterfaceMessage;
//		}
//
//		public function getTargetLanguage() {
//			return this.mTargetLanguage;
//		}
//
//		public function getMaxIncludeSize() {
//			return this.mMaxIncludeSize;
//		}
//
//		public function getMaxPPNodeCount() {
//			return this.mMaxPPNodeCount;
//		}
//
//		public function getMaxGeneratedPPNodeCount() {
//			return this.mMaxGeneratedPPNodeCount;
//		}
//
//		public function getMaxPPExpandDepth() {
//			return this.mMaxPPExpandDepth;
//		}
//
//		public function getMaxTemplateDepth() {
//			return this.mMaxTemplateDepth;
//		}
//
//		/* @since 1.20 */
//		public function getExpensiveParserFunctionLimit() {
//			return this.mExpensiveParserFunctionLimit;
//		}
//
//		public function getRemoveComments() {
//			return this.mRemoveComments;
//		}
//
//		/* @since 1.24 */
//		public function getCurrentRevisionCallback() {
//			return this.mCurrentRevisionCallback;
//		}
//
//		public function getTemplateCallback() {
//			return this.mTemplateCallback;
//		}
//
//		/** @since 1.28 */
//		public function getSpeculativeRevIdCallback() {
//			return this.mSpeculativeRevIdCallback;
//		}
//
//		public function getEnableLimitReport() {
//			return this.mEnableLimitReport;
//		}
//
//		public function getCleanSignatures() {
//			return this.mCleanSignatures;
//		}
//
//		public function getExternalLinkTarget() {
//			return this.mExternalLinkTarget;
//		}
//
//		public function getDisableContentConversion() {
//			return this.mDisableContentConversion;
//		}
//
//		public function getDisableTitleConversion() {
//			return this.mDisableTitleConversion;
//		}

	public int getThumbSize() {
		// this.optionUsed( 'thumbsize' );

		return this.mThumbSize;
	}

//		public function getStubThreshold() {
//			this.optionUsed( 'stubthreshold' );
//
//			return this.mStubThreshold;
//		}
//
//		public function getIsPreview() {
//			return this.mIsPreview;
//		}
//
//		public function getIsSectionPreview() {
//			return this.mIsSectionPreview;
//		}
//
//		public function getIsPrintable() {
//			this.optionUsed( 'printable' );
//
//			return this.mIsPrintable;
//		}
//
//		public function getUser() {
//			return this.mUser;
//		}
//
//		public function getPreSaveTransform() {
//			return this.mPreSaveTransform;
//		}
//
//		public function getDateFormat() {
//			this.optionUsed( 'dateformat' );
//			if ( !isset( this.mDateFormat ) ) {
//				this.mDateFormat = this.mUser->getDatePreference();
//			}
//			return this.mDateFormat;
//		}
//
//		public function getTimestamp() {
//			if ( !isset( this.mTimestamp ) ) {
//				this.mTimestamp = wfTimestampNow();
//			}
//			return this.mTimestamp;
//		}
//
//		/**
//		* Get the user language used by the parser for this page and split the parser cache.
//		*
//		* @warning: Calling this causes the parser cache to be fragmented by user language!
//		* To avoid cache fragmentation, output should not depend on the user language.
//		* Use Parser::getFunctionLang() or Parser::getTargetLanguage() instead!
//		*
//		* @note This function will trigger a cache fragmentation by recording the
//		* 'userlang' option, see optionUsed(). This is done to avoid cache pollution
//		* when the page is rendered based on the language of the user.
//		*
//		* @note When saving, this will return the default language instead of the user's.
//		* {{int: }} uses this which used to produce inconsistent link tables (bug 14404).
//		*
//		* @return Language
//		* @since 1.19
//		*/
//		public function getUserLangObj() {
//			this.optionUsed( 'userlang' );
//			return this.mUserLang;
//		}
//
//		/**
//		* Same as getUserLangObj() but returns a String instead.
//		*
//		* @warning: Calling this causes the parser cache to be fragmented by user language!
//		* To avoid cache fragmentation, output should not depend on the user language.
//		* Use Parser::getFunctionLang() or Parser::getTargetLanguage() instead!
//		*
//		* @see getUserLangObj()
//		*
//		* @return String Language code
//		* @since 1.17
//		*/
//		public function getUserLang() {
//			return this.getUserLangObj()->getCode();
//		}
//
//		/**
//		* @since 1.28
//		* @return boolean
//		*/
//		public function getMagicISBNLinks() {
//			return this.mMagicISBNLinks;
//		}
//
//		/**
//		* @since 1.28
//		* @return boolean
//		*/
//		public function getMagicPMIDLinks() {
//			return this.mMagicPMIDLinks;
//		}
//		/**
//		* @since 1.28
//		* @return boolean
//		*/
//		public function getMagicRFCLinks() {
//			return this.mMagicRFCLinks;
//		}
//		public function setInterwikiMagic( $x ) {
//			return wfSetVar( this.mInterwikiMagic, $x );
//		}
//
//		public function setAllowExternalImages( $x ) {
//			return wfSetVar( this.mAllowExternalImages, $x );
//		}
//
//		public function setAllowExternalImagesFrom( $x ) {
//			return wfSetVar( this.mAllowExternalImagesFrom, $x );
//		}
//
//		public function setEnableImageWhitelist( $x ) {
//			return wfSetVar( this.mEnableImageWhitelist, $x );
//		}
//
//		public function setDateFormat( $x ) {
//			return wfSetVar( this.mDateFormat, $x );
//		}
//
//		public function setEditSection( $x ) {
//			return wfSetVar( this.mEditSection, $x );
//		}
//
//		public function setNumberHeadings( $x ) {
//			return wfSetVar( this.mNumberHeadings, $x );
//		}
//
//		public function setAllowSpecialInclusion( $x ) {
//			return wfSetVar( this.mAllowSpecialInclusion, $x );
//		}
//
//		public function setTidy( $x ) {
//			return wfSetVar( this.mTidy, $x );
//		}
//
//		public function setInterfaceMessage( $x ) {
//			return wfSetVar( this.mInterfaceMessage, $x );
//		}
//
//		public function setTargetLanguage( $x ) {
//			return wfSetVar( this.mTargetLanguage, $x, true );
//		}
//
//		public function setMaxIncludeSize( $x ) {
//			return wfSetVar( this.mMaxIncludeSize, $x );
//		}
//
//		public function setMaxPPNodeCount( $x ) {
//			return wfSetVar( this.mMaxPPNodeCount, $x );
//		}
//
//		public function setMaxGeneratedPPNodeCount( $x ) {
//			return wfSetVar( this.mMaxGeneratedPPNodeCount, $x );
//		}
//
//		public function setMaxTemplateDepth( $x ) {
//			return wfSetVar( this.mMaxTemplateDepth, $x );
//		}
//
//		/* @since 1.20 */
//		public function setExpensiveParserFunctionLimit( $x ) {
//			return wfSetVar( this.mExpensiveParserFunctionLimit, $x );
//		}
//
//		public function setRemoveComments( $x ) {
//			return wfSetVar( this.mRemoveComments, $x );
//		}
//
//		/* @since 1.24 */
//		public function setCurrentRevisionCallback( $x ) {
//			return wfSetVar( this.mCurrentRevisionCallback, $x );
//		}
//
//		/** @since 1.28 */
//		public function setSpeculativeRevIdCallback( $x ) {
//			return wfSetVar( this.mSpeculativeRevIdCallback, $x );
//		}
//
//		public function setTemplateCallback( $x ) {
//			return wfSetVar( this.mTemplateCallback, $x );
//		}
//
//		public function enableLimitReport( $x = true ) {
//			return wfSetVar( this.mEnableLimitReport, $x );
//		}
//
//		public function setTimestamp( $x ) {
//			return wfSetVar( this.mTimestamp, $x );
//		}
//
//		public function setCleanSignatures( $x ) {
//			return wfSetVar( this.mCleanSignatures, $x );
//		}
//
//		public function setExternalLinkTarget( $x ) {
//			return wfSetVar( this.mExternalLinkTarget, $x );
//		}
//
//		public function disableContentConversion( $x = true ) {
//			return wfSetVar( this.mDisableContentConversion, $x );
//		}
//
//		public function disableTitleConversion( $x = true ) {
//			return wfSetVar( this.mDisableTitleConversion, $x );
//		}
//
//		public function setUserLang( $x ) {
//			if ( is_string( $x ) ) {
//				$x = Language::factory( $x );
//			}
//
//			return wfSetVar( this.mUserLang, $x );
//		}
//
//		public function setThumbSize( $x ) {
//			return wfSetVar( this.mThumbSize, $x );
//		}
//
//		public function setStubThreshold( $x ) {
//			return wfSetVar( this.mStubThreshold, $x );
//		}
//
//		public function setPreSaveTransform( $x ) {
//			return wfSetVar( this.mPreSaveTransform, $x );
//		}
//
//		public function setIsPreview( $x ) {
//			return wfSetVar( this.mIsPreview, $x );
//		}
//
//		public function setIsSectionPreview( $x ) {
//			return wfSetVar( this.mIsSectionPreview, $x );
//		}
//
//		public function setIsPrintable( $x ) {
//			return wfSetVar( this.mIsPrintable, $x );
//		}
//
//		/**
//		* Set the redirect target.
//		*
//		* Note that setting or changing this does not *make* the page a redirect
//		* or change its target, it merely records the information for reference
//		* during the parse.
//		*
//		* @since 1.24
//		* @param Title|null $title
//		*/
//		function setRedirectTarget( $title ) {
//			this.redirectTarget = $title;
//		}
//
//		/**
//		* Get the previously-set redirect target.
//		*
//		* @since 1.24
//		* @return Title|null
//		*/
//		function getRedirectTarget() {
//			return this.redirectTarget;
//		}
//
//		/**
//		* Extra key that should be present in the parser cache key.
//		* @param String $key
//		*/
//		public function addExtraKey( $key ) {
//			this.mExtraKey .= '!' . $key;
//		}
//
//		/**
//		* Constructor
//		* @param User $user
//		* @param Language $lang
//		*/
//		public function __construct( $user = null, $lang = null ) {
//			if ( $user === null ) {
//				global $wgUser;
//				if ( $wgUser === null ) {
//					$user = new User;
//				} else {
//					$user = $wgUser;
//				}
//			}
//			if ( $lang === null ) {
//				global $wgLang;
//				if ( !StubObject::isRealObject( $wgLang ) ) {
//					$wgLang->_unstub();
//				}
//				$lang = $wgLang;
//			}
//			this.initialiseFromUser( $user, $lang );
//		}
//
//		/**
//		* Get a ParserOptions Object for an anonymous user
//		* @since 1.27
//		* @return ParserOptions
//		*/
//		public static function newFromAnon() {
//			global $wgContLang;
//			return new ParserOptions( new User, $wgContLang );
//		}
//
//		/**
//		* Get a ParserOptions Object from a given user.
//		* Language will be taken from $wgLang.
//		*
//		* @param User $user
//		* @return ParserOptions
//		*/
//		public static function newFromUser( $user ) {
//			return new ParserOptions( $user );
//		}
//
//		/**
//		* Get a ParserOptions Object from a given user and language
//		*
//		* @param User $user
//		* @param Language $lang
//		* @return ParserOptions
//		*/
//		public static function newFromUserAndLang( User $user, Language $lang ) {
//			return new ParserOptions( $user, $lang );
//		}
//
//		/**
//		* Get a ParserOptions Object from a IContextSource Object
//		*
//		* @param IContextSource $context
//		* @return ParserOptions
//		*/
//		public static function newFromContext( IContextSource $context ) {
//			return new ParserOptions( $context->getUser(), $context->getLanguage() );
//		}
//
//		/**
//		* Get user options
//		*
//		* @param User $user
//		* @param Language $lang
//		*/
//		private function initialiseFromUser( $user, $lang ) {
//			global $wgInterwikiMagic, $wgAllowExternalImages,
//				$wgAllowExternalImagesFrom, $wgEnableImageWhitelist, $wgAllowSpecialInclusion,
//				$wgMaxArticleSize, $wgMaxPPNodeCount, $wgMaxTemplateDepth, $wgMaxPPExpandDepth,
//				$wgCleanSignatures, $wgExternalLinkTarget, $wgExpensiveParserFunctionLimit,
//				$wgMaxGeneratedPPNodeCount, $wgDisableLangConversion, $wgDisableTitleConversion,
//				$wgEnableMagicLinks;
//
//			// *UPDATE* ParserOptions::matches() if any of this changes as needed
//			this.mInterwikiMagic = $wgInterwikiMagic;
//			this.mAllowExternalImages = $wgAllowExternalImages;
//			this.mAllowExternalImagesFrom = $wgAllowExternalImagesFrom;
//			this.mEnableImageWhitelist = $wgEnableImageWhitelist;
//			this.mAllowSpecialInclusion = $wgAllowSpecialInclusion;
//			this.mMaxIncludeSize = $wgMaxArticleSize * 1024;
//			this.mMaxPPNodeCount = $wgMaxPPNodeCount;
//			this.mMaxGeneratedPPNodeCount = $wgMaxGeneratedPPNodeCount;
//			this.mMaxPPExpandDepth = $wgMaxPPExpandDepth;
//			this.mMaxTemplateDepth = $wgMaxTemplateDepth;
//			this.mExpensiveParserFunctionLimit = $wgExpensiveParserFunctionLimit;
//			this.mCleanSignatures = $wgCleanSignatures;
//			this.mExternalLinkTarget = $wgExternalLinkTarget;
//			this.mDisableContentConversion = $wgDisableLangConversion;
//			this.mDisableTitleConversion = $wgDisableLangConversion || $wgDisableTitleConversion;
//			this.mMagicISBNLinks = $wgEnableMagicLinks['ISBN'];
//			this.mMagicPMIDLinks = $wgEnableMagicLinks['PMID'];
//			this.mMagicRFCLinks = $wgEnableMagicLinks['RFC'];
//
//			this.mUser = $user;
//			this.mNumberHeadings = $user->getOption( 'numberheadings' );
//			this.mThumbSize = $user->getOption( 'thumbsize' );
//			this.mStubThreshold = $user->getStubThreshold();
//			this.mUserLang = $lang;
//		}
//
//		/**
//		* Check if these options match that of another options set
//		*
//		* This ignores report limit settings that only affect HTML comments
//		*
//		* @param ParserOptions $other
//		* @return boolean
//		* @since 1.25
//		*/
//		public function matches( ParserOptions $other ) {
//			$fields = array_keys( get_class_vars( __CLASS__ ) );
//			$fields = array_diff( $fields, [
//				'mEnableLimitReport', // only effects HTML comments
//				'onAccessCallback', // only used for ParserOutput option tracking
//			] );
//			foreach ( $fields as $field ) {
//				if ( !is_object( this.$field ) && this.$field !== $other->$field ) {
//					return false;
//				}
//			}
//			// Check the Object and lazy-loaded options
//			return (
//				this.mUserLang->equals( $other->mUserLang ) &&
//				this.getDateFormat() === $other->getDateFormat()
//			);
//		}
//
//		/**
//		* Registers a callback for tracking which ParserOptions which are used.
//		* This is a private API with the parser.
//		* @param callable $callback
//		*/
//		public function registerWatcher( $callback ) {
//			this.onAccessCallback = $callback;
//		}
//
//		/**
//		* Called when an option is accessed.
//		* Calls the watcher that was set using registerWatcher().
//		* Typically, the watcher callback is ParserOutput::registerOption().
//		* The information registered that way will be used by ParserCache::save().
//		*
//		* @param String $optionName Name of the option
//		*/
//		public function optionUsed( $optionName ) {
//			if ( this.onAccessCallback ) {
//				call_user_func( this.onAccessCallback, $optionName );
//			}
//		}
//
//		/**
//		* Returns the full array of options that would have been used by
//		* in 1.16.
//		* Used to get the old parser cache entries when available.
//		* @return array
//		*/
//		public static function legacyOptions() {
//			return [
//				'stubthreshold',
//				'numberheadings',
//				'userlang',
//				'thumbsize',
//				'editsection',
//				'printable'
//			];
//		}
//
//		/**
//		* Generate a hash String with the values set on these ParserOptions
//		* for the keys given in the array.
//		* This will be used as part of the hash key for the parser cache,
//		* so users sharing the options with vary for the same page share
//		* the same cached data safely.
//		*
//		* Extensions which require it should install 'PageRenderingHash' hook,
//		* which will give them a chance to modify this key based on their own
//		* settings.
//		*
//		* @since 1.17
//		* @param array $forOptions
//		* @param Title $title Used to get the content language of the page (since r97636)
//		* @return String Page rendering hash
//		*/
//		public function optionsHash( $forOptions, $title = null ) {
//			global $wgRenderHashAppend;
//
//			// FIXME: Once the cache key is reorganized this argument
//			// can be dropped. It was used when the math extension was
//			// part of core.
//			$confstr = '*';
//
//			// Space assigned for the stubthreshold but unused
//			// since it disables the parser cache, its value will always
//			// be 0 when this function is called by parsercache.
//			if ( in_array( 'stubthreshold', $forOptions ) ) {
//				$confstr .= '!' . this.mStubThreshold;
//			} else {
//				$confstr .= '!*';
//			}
//
//			if ( in_array( 'dateformat', $forOptions ) ) {
//				$confstr .= '!' . this.getDateFormat();
//			}
//
//			if ( in_array( 'numberheadings', $forOptions ) ) {
//				$confstr .= '!' . ( this.mNumberHeadings ? '1' : '' );
//			} else {
//				$confstr .= '!*';
//			}
//
//			if ( in_array( 'userlang', $forOptions ) ) {
//				$confstr .= '!' . this.mUserLang->getCode();
//			} else {
//				$confstr .= '!*';
//			}
//
//			if ( in_array( 'thumbsize', $forOptions ) ) {
//				$confstr .= '!' . this.mThumbSize;
//			} else {
//				$confstr .= '!*';
//			}
//
//			// add in language specific options, if any
//			// @todo FIXME: This is just a way of retrieving the url/user preferred variant
//			if ( !is_null( $title ) ) {
//				$confstr .= $title->getPageLanguage()->getExtraHashOptions();
//			} else {
//				global $wgContLang;
//				$confstr .= $wgContLang->getExtraHashOptions();
//			}
//
//			$confstr .= $wgRenderHashAppend;
//
//			// @note: as of Feb 2015, core never sets the editsection flag, since it uses
//			// <mw:editsection> tags to inject editsections on the fly. However, extensions
//			// may be using it by calling ParserOption::optionUsed resp. ParserOutput::registerOption
//			// directly. At least Wikibase does at this point in time.
//			if ( !in_array( 'editsection', $forOptions ) ) {
//				$confstr .= '!*';
//			} elseif ( !this.mEditSection ) {
//				$confstr .= '!edit=0';
//			}
//
//			if ( this.mIsPrintable && in_array( 'printable', $forOptions ) ) {
//				$confstr .= '!printable=1';
//			}
//
//			if ( this.mExtraKey != '' ) {
//				$confstr .= this.mExtraKey;
//			}
//
//			// Give a chance for extensions to modify the hash, if they have
//			// extra options or other effects on the parser cache.
//			Hooks::run( 'PageRenderingHash', [ &$confstr, this.getUser(), &$forOptions ] );
//
//			// Make it a valid memcached key fragment
//			$confstr = str_replace( ' ', '_', $confstr );
//
//			return $confstr;
//		}
//
//		/**
//		* Sets a hook to force that a page exists, and sets a current revision callback to return
//		* a revision with custom content when the current revision of the page is requested.
//		*
//		* @since 1.25
//		* @param Title $title
//		* @param Content $content
//		* @param User $user The user that the fake revision is attributed to
//		* @return ScopedCallback to unset the hook
//		*/
//		public function setupFakeRevision( $title, $content, $user ) {
//			$oldCallback = this.setCurrentRevisionCallback(
//				function (
//					$titleToCheck, $parser = false ) use ( $title, $content, $user, &$oldCallback
//				) {
//					if ( $titleToCheck->equals( $title ) ) {
//						return new Revision( [
//							'page' => $title->getArticleID(),
//							'user_text' => $user->getName(),
//							'user' => $user->getId(),
//							'parent_id' => $title->getLatestRevID(),
//							'title' => $title,
//							'content' => $content
//						] );
//					} else {
//						return call_user_func( $oldCallback, $titleToCheck, $parser );
//					}
//				}
//			);
//
//			global $wgHooks;
//			$wgHooks['TitleExists'][] =
//				function ( $titleToCheck, &$exists ) use ( $title ) {
//					if ( $titleToCheck->equals( $title ) ) {
//						$exists = true;
//					}
//				};
//			end( $wgHooks['TitleExists'] );
//			$key = key( $wgHooks['TitleExists'] );
//			LinkCache::singleton()->clearBadLink( $title->getPrefixedDBkey() );
//			return new ScopedCallback( function () use ( $title, $key ) {
//				global $wgHooks;
//				unset( $wgHooks['TitleExists'][$key] );
//				LinkCache::singleton()->clearLink( $title );
//			} );
//		}
}
