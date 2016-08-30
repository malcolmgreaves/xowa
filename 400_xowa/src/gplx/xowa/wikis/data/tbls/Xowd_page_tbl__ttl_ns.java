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
package gplx.xowa.wikis.data.tbls; import gplx.*; import gplx.xowa.*; import gplx.xowa.wikis.*; import gplx.xowa.wikis.data.*;
import gplx.core.criterias.*;
import gplx.dbs.*; import gplx.dbs.utls.*;
import gplx.xowa.wikis.nss.*;
class Xowd_page_tbl__ttl_ns extends Xowd_page_tbl__in_wkr__base {
	private Xowd_page_tbl page_tbl;
	private Xow_ns_mgr ns_mgr; private Ordered_hash hash;
	@Override protected int Interval() {return 64;}	// NOTE: 96+ overflows; PAGE:en.w:Space_Liability_Convention; DATE:2013-10-24
	public void Init(Xowd_page_tbl page_tbl, Xow_ns_mgr ns_mgr, Ordered_hash hash) {
		this.page_tbl = page_tbl;
		this.ns_mgr = ns_mgr; this.hash = hash;
	}
	@Override protected Criteria In_filter(Object[] part_ary) {
		int len = part_ary.length;
		Criteria[] crt_ary = new Criteria[len];
		String fld_ns = tbl.Fld_page_ns(); String fld_ttl = tbl.Fld_page_title();
		for (int i = 0; i < len; i++)
			crt_ary[i] = Criteria_.And(Db_crt_.New_eq(fld_ns, 0), Db_crt_.New_eq(fld_ttl, Bry_.Empty));
		return Criteria_.Or_many(crt_ary);
	}
	@Override protected void Fill_stmt(Db_stmt stmt, int bgn, int end) {
		for (int i = bgn; i < end; i++) {
			Xowd_page_itm page = (Xowd_page_itm)hash.Get_at(i);
			stmt.Crt_int(page_tbl.Fld_page_ns(), page.Ns_id());
			stmt.Crt_bry_as_str(page_tbl.Fld_page_title(), page.Ttl_page_db());
		}
	}
	@Override protected Xowd_page_itm Get_page_or_null(Xowd_page_itm rdr_page) {
		Xow_ns ns = ns_mgr.Ids_get_or_null(rdr_page.Ns_id());
		if (ns == null) return null;	// NOTE: ns seems to "randomly" be null when threading during redlinks; guard against null; DATE:2014-01-03
		byte[] ttl_wo_ns = rdr_page.Ttl_page_db();
		rdr_page.Ttl_(ns, ttl_wo_ns);
		return (Xowd_page_itm)hash.Get_by(rdr_page.Ttl_full_db());
	}
}
