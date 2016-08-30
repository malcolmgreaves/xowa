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
package gplx.xowa.addons.bldrs.exports.merges; import gplx.*; import gplx.xowa.*; import gplx.xowa.addons.*; import gplx.xowa.addons.bldrs.*; import gplx.xowa.addons.bldrs.exports.*;
import gplx.core.progs.*; import gplx.dbs.bulks.*;
public class Merge_prog_wkr implements Db_bulk_prog {
	private final    Gfo_prog_ui prog_ui;
	private final    Merge_prog_checkpoint checkpoint;
	private final    int prog_count_end;		
	private int prog_count_cur;
	private long time_nxt, time_gap = 100;
	// private final    int[] mergepoint_ary = new int[gplx.xowa.addons.bldrs.exports.splits.rslts.Split_rslt_tid_.Tid_max];
	public Merge_prog_wkr(Gfo_prog_ui prog_ui, Io_url checkpoint_fil, int prog_count_end, long prog_size_end) {
		this.prog_ui = prog_ui;
		this.checkpoint = new Merge_prog_checkpoint(checkpoint_fil);
		this.prog_count_end = prog_count_end;
	}		
	public boolean Canceled()							{return prog_ui.Canceled();}
	public long Checkpoint__load() {
		long rv = checkpoint.Load();
		this.prog_count_cur = (int)rv;
		return rv;
	}
	public int Checkpoint__resume_db() {return checkpoint.Resume_db();}
	public void Checkpoint__delete() {checkpoint.Delete();}
	public boolean Checkpoint__skip_fil(Io_url fil)	{return checkpoint.Skip_fil(fil);}
	private Io_url cur_fil; private byte cur_wkr_tid;
	public boolean Checkpoint__skip_wkr(Io_url fil, byte wkr_tid) {
		boolean rv = checkpoint.Skip_wkr(wkr_tid);
		if (rv) return true;
		this.cur_fil = fil;
		this.cur_wkr_tid = wkr_tid;
		this.Checkpoint__save();
		time_nxt = gplx.core.envs.System_.Ticks() + time_gap;
		return false;
	}
	public void Checkpoint__save() {
		// cur_wkr.Resume__db_id()
		checkpoint.Save(cur_fil, cur_wkr_tid, -1, prog_count_cur);
	}
	public boolean Prog__insert_and_stop_if_suspended(int row_size) {
		++prog_count_cur;
		long time_cur = gplx.core.envs.System_.Ticks();
		if (time_cur < time_nxt) return false;
		// gplx.core.threads.Thread_adp_.Sleep(10);
		time_nxt = time_cur + time_gap;
		boolean rv = prog_ui.Prog_notify_and_chk_if_suspended(prog_count_cur, prog_count_end);
		return rv;
	}
}
