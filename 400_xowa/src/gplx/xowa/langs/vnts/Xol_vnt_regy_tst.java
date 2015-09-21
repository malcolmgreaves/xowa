/*
XOWA: the XOWA Offline Wiki Application
Copyright (C) 2012 gnosygnu@gmail.com

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package gplx.xowa.langs.vnts; import gplx.*; import gplx.xowa.*; import gplx.xowa.langs.*;
import org.junit.*; import gplx.xowa.parsers.vnts.*;
public class Xol_vnt_regy_tst {
	private final Xol_vnt_regy_fxt fxt = new Xol_vnt_regy_fxt();
	@Test  public void Calc() {
		fxt.Test_calc(String_.Ary("zh")				, 1);
		fxt.Test_calc(String_.Ary("zh", "zh-hans")	, 3);
		fxt.Test_calc(String_.Ary("zh", "bad")		, 1);
	}
	@Test  public void Match() {
		String[] lang_chain = fxt.Make_lang_chain_cn();	// zh;zh-hans;zh-hant;zh-cn
		fxt.Test_match_any(Bool_.Y, lang_chain
		, String_.Ary("zh")
		, String_.Ary("zh-hans")
		, String_.Ary("zh-hant")
		, String_.Ary("zh-cn")
		, String_.Ary("zh", "zh-hans")
		, String_.Ary("zh-cn", "zh-hk")
		);
		fxt.Test_match_any(Bool_.N, lang_chain
		, String_.Ary_empty
		, String_.Ary("bad")
		, String_.Ary("zh-hk")
		, String_.Ary("zh-hk", "zh-sg")
		);
	}
	@Test   public void Match_2() {
		fxt.Test_match_any(Bool_.Y, String_.Ary("zh-hans")
		, String_.Ary("zh", "zh-hant", "zh-hans")
		);
	}
	@Test  public void Sort() {
		fxt.Test_sort(String_.Ary("zh"								)	, String_.Ary("zh"));
		fxt.Test_sort(String_.Ary("zh", "zh-hans", "zh-cn"			)	, String_.Ary("zh-cn", "zh-hans", "zh"));
	}
}
class Xol_vnt_regy_fxt {
	private final Xol_vnt_regy mgr = new Xol_vnt_regy();
	public Xol_vnt_regy_fxt() {
		String[] ary = Xop_vnt_parser_fxt.Vnts_chinese;
		for (String itm : ary)
			mgr.Add(Bry_.new_u8(itm), Bry_.Empty);
	}
	public String[] Make_lang_chain_cn() {return String_.Ary("zh-cn", "zh-hans", "zh-hant", "zh");}
	public void Test_match_any(boolean expd, String[] lang_chain, String[]... vnt_chain_ary) {
		int len = vnt_chain_ary.length;
		int lang_flag = mgr.Mask__calc(Bry_.Ary(lang_chain));
		for (int i = 0; i < len; ++i) {
			String[] vnt_chain = vnt_chain_ary[i];	// EX: -{zh;zh-hans;zh-hant}-
			int vnt_flag = mgr.Mask__calc(Bry_.Ary(vnt_chain));
			Tfds.Eq(expd, mgr.Mask__match_any(vnt_flag, lang_flag), String_.Concat_with_str(";", vnt_chain) + "<>" + String_.Concat_with_str(";", lang_chain));
		}
	}
	public void Test_calc(String[] ary, int expd) {
		Tfds.Eq(expd, mgr.Mask__calc(Bry_.Ary(ary)));
	}
	public void Test_sort(String[] vnt_ary, String[] expd) {
		int vnt_len = vnt_ary.length;
		Xop_vnt_rule_tkn[] rule_ary = new Xop_vnt_rule_tkn[vnt_len];
		for (int i = 0; i < vnt_len; ++i)
			rule_ary[i] = new Xop_vnt_rule_tkn(Bry_.Empty, Bry_.new_u8(vnt_ary[i]), gplx.xowa.parsers.Xop_tkn_itm_.Ary_empty);
		mgr.Mask__sort(rule_ary);
		for (int i = 0; i < vnt_len; ++i)
			vnt_ary[i] = String_.new_u8(rule_ary[i].Rule_lang());
		Tfds.Eq_ary_str(expd, vnt_ary);
	}
}