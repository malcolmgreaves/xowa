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
package gplx.xowa.mediawiki.includes.utls; import gplx.*; import gplx.xowa.*; import gplx.xowa.mediawiki.*; import gplx.xowa.mediawiki.includes.*;
import org.junit.*; import gplx.core.tests.*;
public class Xomw_ttl_utl__tst {
	private final    Xomw_ttl_utl__fxt fxt = new Xomw_ttl_utl__fxt();
	@Test  public void Alphanum()           {fxt.Test__find_fwd_while_title("0aB"             , 3);}
	@Test  public void Angle()              {fxt.Test__find_fwd_while_title("0a<"             , 2);}
}
class Xomw_ttl_utl__fxt {
	public void Test__find_fwd_while_title(String src_str, int expd) {
		byte[] src_bry = Bry_.new_u8(src_str);
		Gftest.Eq__int(expd, Xomw_ttl_utl.Find_fwd_while_title(src_bry, 0, src_bry.length, Xomw_ttl_utl.Title_chars_valid()));
	}
}