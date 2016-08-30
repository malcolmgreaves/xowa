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
package gplx.xowa.apps.wms.apis.parses; import gplx.*; import gplx.xowa.*; import gplx.xowa.apps.*; import gplx.xowa.apps.wms.*; import gplx.xowa.apps.wms.apis.*;
import gplx.core.tests.*;
import gplx.langs.htmls.*; import gplx.xowa.htmls.*;
import gplx.xowa.files.*; import gplx.xowa.files.repos.*;
class Xowm_parse_mgr_fxt {
	private final    Wm_page_updater mgr = new Wm_page_updater();		
	private final    Bry_bfr tmp_bfr = Bry_bfr_.New();
	private final    Xoh_page hpg = new Xoh_page();
	private Xowe_wiki wiki;
	public void Clear() {
		Xoae_app app = Xoa_app_fxt.Make__app__edit();
		this.wiki = Xoa_app_fxt.Make__wiki__edit(app);
		Xoa_app_fxt.repo2_(app, wiki);
		mgr.Init_by_app(app);
		mgr.Init_by_page(wiki, hpg);
	}
	public Xowm_parse_mgr_fxt Exec__parse(String raw) {
		mgr.Parse(hpg, wiki, Bry_.Empty, Bry_.new_u8(raw));
		return this;
	}
	public Xowm_parse_mgr_fxt Test__html(String expd) {
		Gftest.Eq__ary__lines(expd, hpg.Db().Html().Html_bry(), "converted html");
		return this;
	}
	public Xof_fsdb_itm Make__fsdb(boolean repo_is_commons, boolean file_is_thumb, String file_ttl, int file_w, double file_time, int file_page) {
		Xof_fsdb_itm itm = new Xof_fsdb_itm();
		itm.Init_by_wm_parse(wiki.Domain_itm().Abrv_xo(), repo_is_commons, file_is_thumb, Bry_.new_u8(file_ttl), file_w, file_time, file_page);
		return itm;
	}
	public Xowm_parse_mgr_fxt Test__fsdb(Xof_fsdb_itm expd) {
		Xof_fsdb_itm actl = (Xof_fsdb_itm)hpg.Hdump_mgr().Imgs().Get_at(0);
		Gftest.Eq__str(To_str(tmp_bfr, expd), To_str(tmp_bfr, actl));
		return this;
	}
	public static String To_str(Bry_bfr tmp_bfr, Xof_fsdb_itm itm) {
		To_bfr(tmp_bfr, itm);
		return tmp_bfr.To_str_and_clear();
	}
	private static void To_bfr(Bry_bfr bfr, Xof_fsdb_itm itm) {
		bfr.Add_str_a7(itm.Orig_repo_id() == Xof_repo_itm_.Repo_remote ? "remote" : "local").Add_byte_pipe();
		bfr.Add_str_a7(itm.File_is_orig() ? "orig" : "thumb").Add_byte_pipe();
		bfr.Add(itm.Orig_ttl()).Add_byte_pipe();
		bfr.Add_int_variable(itm.File_w()).Add_byte_pipe();
		bfr.Add_double(itm.Lnki_time()).Add_byte_pipe();
		bfr.Add_int_variable(itm.Lnki_page()).Add_byte_pipe();
	}
}
