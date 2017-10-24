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
package gplx.gfui.controls.customs; import gplx.*; import gplx.gfui.*; import gplx.gfui.controls.*;
import gplx.gfui.kits.core.*; import gplx.gfui.controls.gxws.*; import gplx.gfui.controls.elems.*;
public class GfuiStatusBox_ {
	public static GfuiStatusBox new_(String key) {
		GfuiStatusBox rv = new GfuiStatusBox();
		rv.ctor_GfuiBox_base(GfuiElem_.init_focusAble_false_());
		rv.Key_of_GfuiElem_(key);
		return rv;
	}
	public static GfuiStatusBox kit_(Gfui_kit kit, String key, GxwElem underElem) {
		GfuiStatusBox rv = new GfuiStatusBox();
		rv.ctor_kit_GfuiElemBase(kit, key, underElem, GfuiElem_.init_focusAble_false_());
		return rv;
	}
}
