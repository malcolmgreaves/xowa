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
package gplx.xowa.bldrs.infos; import gplx.*; import gplx.xowa.*; import gplx.xowa.bldrs.*;
import gplx.dbs.cfgs.*;
public class Xob_info_session {
	Xob_info_session(String user, String version, String wiki_domain, String dump_name, DateAdp time, Guid_adp guid) {
		this.user = user; this.version = version; this.wiki_domain = wiki_domain; this.dump_name = dump_name; this.time = time; this.guid = guid;
	}
	public String User() {return user;} private final String user;
	public String Version() {return version;} private final String version;
	public String Wiki_domain() {return wiki_domain;} private final String wiki_domain;
	public String Dump_name() {return dump_name;} private final String dump_name;
	public DateAdp Time() {return time;} private final DateAdp time;
	public Guid_adp Uuid() {return guid;} private final Guid_adp guid;
	public void Save(Db_cfg_tbl tbl) {
		tbl.Conn().Txn_bgn();
		tbl.Insert_str		(Cfg_grp, Cfg_key__user			, user);
		tbl.Insert_str		(Cfg_grp, Cfg_key__version		, version);
		tbl.Insert_str		(Cfg_grp, Cfg_key__wiki_domain	, wiki_domain);
		tbl.Insert_str		(Cfg_grp, Cfg_key__dump_name	, dump_name);
		tbl.Insert_date		(Cfg_grp, Cfg_key__time			, time);
		tbl.Insert_guid		(Cfg_grp, Cfg_key__guid			, guid);
		tbl.Conn().Txn_end();
	}
	public static Xob_info_session Load(Db_cfg_tbl tbl) {
		Db_cfg_hash hash = tbl.Select_as_hash(Cfg_grp);
		return new Xob_info_session
		( hash.Get(Cfg_key__user).To_str_or("")
		, hash.Get(Cfg_key__version).To_str_or("")
		, hash.Get(Cfg_key__wiki_domain).To_str_or("")
		, hash.Get(Cfg_key__dump_name).To_str_or("")
		, hash.Get(Cfg_key__time).To_date_or(DateAdp_.MinValue)
		, hash.Get(Cfg_key__guid).To_guid_or(Guid_adp_.Empty)
		);
	}
	private static final String Cfg_grp = gplx.xowa.wikis.Xow_cfg_consts.Grp__bldr_session
	, Cfg_key__user				= "user"			// EX: anonymous
	, Cfg_key__version			= "version"			// EX: 2.3.1.4
	, Cfg_key__wiki_domain		= "wiki_domain"		// EX: en.wikipedia.org
	, Cfg_key__dump_name		= "dump_name"		// EX: enwiki-latest-pages-articles
	, Cfg_key__time				= "time"			// EX: 20150102 030405
	, Cfg_key__guid				= "guid"			// EX: 00000000-0000-0000-0000-000000000000
	;
	public static Xob_info_session new_(String user, String wiki_domain, String dump_name) {return new Xob_info_session(user, Xoa_app_.Version, wiki_domain, dump_name, DateAdp_.Now(), Guid_adp_.random_());}
	public static final Xob_info_session Test = new_("anonymous", "en.wikipedia.org", "enwiki-latest-pages-articles");
}
