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
package gplx.xowa.addons.updates.downloads.core; import gplx.*; import gplx.xowa.*; import gplx.xowa.addons.*; import gplx.xowa.addons.updates.*; import gplx.xowa.addons.updates.downloads.*;
public class Gfo_download_wkr_ {
	public static final    Gfo_download_wkr Noop = new Gfo_download_wkr__noop();
}
class Gfo_download_wkr__noop implements Gfo_download_wkr {
	public void Download__bgn(Gfo_download_cbk cbk, Gfo_download_itm[] itms) {cbk.Download__end_all(itms);}
}
