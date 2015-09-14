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
import gplx.dbs.*; import gplx.dbs.cfgs.*;
public class Xob_info_file {
	public Xob_info_file(int id, String type, String ns_ids, int part_id, Guid_adp guid, int schema_version, String core_file_name, String orig_file_name) {
		this.id = id; this.type = type; this.ns_ids = ns_ids; this.part_id = part_id; this.guid = guid;
		this.schema_version = schema_version; this.core_file_name = core_file_name; this.orig_file_name = orig_file_name;
	}
	public int Id() {return id;} private final int id;
	public String Type() {return type;} private final String type;
	public String Ns_ids() {return ns_ids;} private final String ns_ids;
	public int Part_id() {return part_id;} private final int part_id;
	public Guid_adp Guid() {return guid;} private final Guid_adp guid;
	public int Schema_version() {return schema_version;} private final int schema_version;
	public String Core_file_name() {return core_file_name;} private final String core_file_name;
	public String Orig_file_name() {return orig_file_name;} private final String orig_file_name;
	public void Save(Db_cfg_tbl tbl) {
		tbl.Conn().Txn_bgn("make__info__file");
		tbl.Insert_int		(Cfg_grp, Cfg_key__id				, id);
		tbl.Insert_str		(Cfg_grp, Cfg_key__type				, type);
		tbl.Insert_str		(Cfg_grp, Cfg_key__ns_ids			, ns_ids);
		tbl.Insert_int		(Cfg_grp, Cfg_key__part_id			, part_id);
		tbl.Insert_guid		(Cfg_grp, Cfg_key__guid				, guid);
		tbl.Insert_int		(Cfg_grp, Cfg_key__schema_version	, schema_version);
		tbl.Insert_str		(Cfg_grp, Cfg_key__core_file_name	, core_file_name);
		tbl.Insert_str		(Cfg_grp, Cfg_key__orig_file_name	, orig_file_name);
		tbl.Conn().Txn_end();
	}
	public static Xob_info_file Load(Db_cfg_tbl tbl) {
		Db_cfg_hash hash = tbl.Select_as_hash(Cfg_grp);
		return new Xob_info_file
		( hash.Get(Cfg_key__id				).To_int_or(-1)
		, hash.Get(Cfg_key__type			).To_str_or("unknown")
		, hash.Get(Cfg_key__ns_ids			).To_str_or("")
		, hash.Get(Cfg_key__part_id			).To_int_or(-1)
		, hash.Get(Cfg_key__guid			).To_guid_or(Guid_adp_.Empty)
		, hash.Get(Cfg_key__schema_version	).To_int_or(2)
		, hash.Get(Cfg_key__core_file_name	).To_str_or("")
		, hash.Get(Cfg_key__orig_file_name	).To_str_or("")
		);
	}
	private static final String Cfg_grp = gplx.xowa.wikis.Xow_cfg_consts.Grp__bldr_db
	, Cfg_key__id				= "id"				// EX: 1
	, Cfg_key__type				= "type"			// EX: core
	, Cfg_key__ns_ids			= "ns_ids"			// EX: 0
	, Cfg_key__part_id			= "part_id"			// EX: 0
	, Cfg_key__guid				= "guid"			// EX: 00000000-0000-0000-0000-000000000000
	, Cfg_key__schema_version	= "schema_version"	// EX: 2
	, Cfg_key__core_file_name	= "core_file_name"	// EX: en.wikipedia.org-text.xowa
	, Cfg_key__orig_file_name	= "orig_file_name"	// EX: en.wikipedia.org-text-ns.000-db.002.xowa
	;
	public static final String Ns_ids_empty = "";
	public static final int Part_id_1st = 1;
}