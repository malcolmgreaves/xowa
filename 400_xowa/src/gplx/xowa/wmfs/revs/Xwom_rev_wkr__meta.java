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
package gplx.xowa.wmfs.revs; import gplx.*; import gplx.xowa.*; import gplx.xowa.wmfs.*;
interface Xowm_rev_wkr__meta {
	void Fetch_meta(byte[] domain_bry, Ordered_hash hash, int bgn, int end);
}
interface Xowm_rev_wkr__text {
	void Fetch_text(Ordered_hash hash, int bgn, int end);
}
class Xowm_rev_wkr__meta__xo {
	public void Fetch_meta(Ordered_hash hash, int bgn, int end) {
	}
}