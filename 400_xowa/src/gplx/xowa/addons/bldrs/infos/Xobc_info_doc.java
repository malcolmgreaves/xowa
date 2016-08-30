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
package gplx.xowa.addons.bldrs.infos; import gplx.*; import gplx.xowa.*; import gplx.xowa.addons.*; import gplx.xowa.addons.bldrs.*;
import gplx.langs.mustaches.*;
class Xobc_info_doc implements Mustache_doc_itm {
	private final    byte[] wiki_domain, task_size;
	private final    String wiki_dir, torrent_fil;
	private final    Mustache_doc_itm[] urls;
	public Xobc_info_doc(byte[] wiki_domain, String wiki_dir, byte[] task_size, String torrent_fil, Mustache_doc_itm[] urls) {
		this.wiki_domain = wiki_domain; this.wiki_dir = wiki_dir; this.task_size = task_size; this.torrent_fil = torrent_fil; this.urls = urls;
	}
	public boolean Mustache__write(String key, Mustache_bfr bfr) {
		if		(String_.Eq(key, "wiki_domain"))	bfr.Add_bry(wiki_domain);
		else if	(String_.Eq(key, "wiki_dir"))		bfr.Add_str_u8(wiki_dir);
		else if	(String_.Eq(key, "task_size"))		bfr.Add_bry(task_size);
		else if	(String_.Eq(key, "torrent_fil"))	bfr.Add_str_u8(torrent_fil);
		return false;
	}
	public Mustache_doc_itm[] Mustache__subs(String key) {
		if		(String_.Eq(key, "urls"))		return urls;
		return Mustache_doc_itm_.Ary__empty;
	}
}
class Xobc_info_url implements Mustache_doc_itm {
	private final    String url, md5; private final    byte[] size;
	public Xobc_info_url(String url, byte[] size, String md5) {
		this.url = url; this.size = size; this.md5 = md5;
	}
	public boolean Mustache__write(String key, Mustache_bfr bfr) {
		if		(String_.Eq(key, "url"))			bfr.Add_str_u8(url);
		else if	(String_.Eq(key, "size"))			bfr.Add_bry(size);
		else if	(String_.Eq(key, "md5"))			bfr.Add_str_u8(md5);
		else										return false;
		return true;
	}
	public Mustache_doc_itm[] Mustache__subs(String key) {return Mustache_doc_itm_.Ary__empty;}
}
