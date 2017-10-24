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
package gplx.dbs.qrys.bats; import gplx.*; import gplx.dbs.*; import gplx.dbs.qrys.*;
import gplx.dbs.engines.*; import gplx.dbs.engines.sqlite.*;
public class Db_batch__journal_off {
	public static void Batch__init(Db_batch_mgr batch_mgr) {
		batch_mgr.Conn_bgn().Add(Db_batch__journal_off__conn_bgn.Instance);
		batch_mgr.Conn_end().Add(Db_batch__journal_off__conn_end.Instance);
	}
	public static void Batch__term(Db_batch_mgr batch_mgr) {
		batch_mgr.Conn_bgn().Del(Db_batch__journal_off__conn_bgn.Instance.Key());
		batch_mgr.Conn_end().Del(Db_batch__journal_off__conn_end.Instance.Key());
	}
}
class Db_batch__journal_off__conn_bgn implements Db_batch_itm {
	public String Key() {return KEY;} public static final String KEY = "journal_off.conn_bgn";
	public void Qry_bat__run(Db_engine engine) {
		engine.Props().Add(Sqlite_pragma.Const__journal_mode, Sqlite_pragma.Const__journal_mode__off);
		engine.Exec_as_obj(Sqlite_pragma.New__journal__off());				// off b/c failure and corruption doesn't matter to import
		engine.Exec_as_obj(Sqlite_pragma.New__synchronous__off());			// off b/c failure and corruption doesn't matter to import
	}
        public static final    Db_batch__journal_off__conn_bgn Instance = new Db_batch__journal_off__conn_bgn(); Db_batch__journal_off__conn_bgn() {}
}
class Db_batch__journal_off__conn_end implements Db_batch_itm {
	public String Key() {return KEY;} public static final String KEY = "journal_off.conn_end";
	public void Qry_bat__run(Db_engine engine) {
		if (!engine.Props().Match(Sqlite_pragma.Const__journal_mode, Sqlite_pragma.Const__journal_mode__off)) return;
		engine.Exec_as_obj(Sqlite_pragma.New__journal__delete());
		engine.Exec_as_obj(Sqlite_pragma.New__synchronous__full());
		engine.Props().Del(Sqlite_pragma.Const__journal_mode);
	}
        public static final    Db_batch__journal_off__conn_end Instance = new Db_batch__journal_off__conn_end(); Db_batch__journal_off__conn_end() {}
}
