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
package gplx.xowa.html.lnkis; import gplx.*; import gplx.xowa.*; import gplx.xowa.html.*;
import gplx.xowa.files.*; import gplx.xowa.hdumps.htmls.*;
class Xoh_file_html_fmtr__hdump extends Xoh_file_html_fmtr__base {
	private Bry_bfr tmp_bfr = Bry_bfr.reset_(128);
	@gplx.Internal @Override protected Xoh_arg_img_core New_arg_img_core() {return new Xoh_arg_img_core__hdump();}
	@Override public void Html_thumb_core(Bry_bfr bfr, int uid, byte[] div1_halign, int div2_width, byte[] div2_content) {
		tmp_bfr.Add(Hdump_html_fmtr__body.Key_img_style);
		tmp_bfr.Add_int_variable(uid);
		tmp_bfr.Add_byte_apos();
		byte[] div2_width_repl = tmp_bfr.XtoAryAndClear();
		fmtr_thumb_core.Bld_bfr_many(bfr, uid, div1_halign, div2_width_repl, div2_content);
	}
	@Override public void Html_thumb_part_magnify(Bry_bfr bfr, int uid, byte[] a_href, byte[] a_title, byte[] img_src)									{Write_xnde(bfr, Hdump_html_fmtr__body.Key_file_mgnf, uid);}
	@Override public void Html_thumb_part_info(Bry_bfr bfr, int uid, byte[] a_href, byte[] img_src)														{Write_xnde(bfr, Hdump_html_fmtr__body.Key_file_info, uid);}
	@Override public void Html_thumb_part_play(Bry_bfr bfr, int uid, int a_width, int a_max_width, byte[] a_href, byte[] a_xowa_title, byte[] img_src)	{Write_xnde(bfr, Hdump_html_fmtr__body.Key_file_play, uid);}
	public static void Write_xnde(Bry_bfr bfr, byte[] key, int uid) {
		bfr.Add(key);
		bfr.Add_int_variable(uid);
		bfr.Add(Bry_xnde_end);
	}	private static final byte[] Bry_xnde_end = Bry_.new_ascii_("'/>");
        public static final Xoh_file_html_fmtr__hdump Hdump = new Xoh_file_html_fmtr__hdump(); Xoh_file_html_fmtr__hdump() {}
}
public class Xoh_file_html_fmtr__base implements Xoh_file_img_wkr {
	private final Xoh_arg_img_core arg_img_core;
	private Bry_bfr scratch_bfr = Bry_bfr.reset_(128);
	public Xoh_file_html_fmtr__base() {
		arg_img_core = New_arg_img_core();
	}
	@gplx.Internal @gplx.Virtual protected Xoh_arg_img_core New_arg_img_core() {return new Xoh_arg_img_core__basic();}
	public void Html_full_media(Bry_bfr tmp_bfr, byte[] a_href, byte[] a_title, Bry_fmtr_arg html) {fmtr_full_media.Bld_bfr_many(tmp_bfr, a_href, a_title, html);}
	private Bry_fmtr fmtr_full_media = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( "<a href=\"~{a_href}\" xowa_title=\"~{a_xowa_title}\">~{html}"
	, "</a>"
	), "a_href", "a_xowa_title", "html"
	);
	public void Html_full_img(Bry_bfr tmp_bfr, Xoa_page page, Xof_xfer_itm xfer_itm, int uid, byte[] a_href, byte[] a_class, byte[] a_rel, byte[] a_title, byte[] a_xowa_title, int img_w, int img_h, byte[] img_src, byte[] img_alt, byte[] img_class) {
		fmtr_full_img.Bld_bfr_many(tmp_bfr, uid, a_href, a_class, a_rel, a_title, a_xowa_title, arg_img_core.Init(uid, img_src, img_w, img_h), img_alt, img_class);
	}
	private Bry_fmtr fmtr_full_img = Bry_fmtr.new_
	( "<a href=\"~{a_href}\"~{a_class}~{a_rel}~{a_title} xowa_title=\"~{a_xowa_title}\">"
	+ "<img id=\"xowa_file_img_~{uid}\" alt=\"~{img_alt}\"~{img_core}~{img_class} /></a>"
	, "uid", "a_href", "a_class", "a_rel", "a_title", "a_xowa_title", "img_core", "img_alt", "img_class"
	);

	@gplx.Virtual public void Html_thumb_core(Bry_bfr tmp_bfr, int uid, byte[] div1_halign, int div2_width, byte[] div2_content) {
		scratch_bfr.Add(Bry_style_bgn);
		scratch_bfr.Add_int_variable(div2_width);
		scratch_bfr.Add(Bry_style_end);
		fmtr_thumb_core.Bld_bfr_many(tmp_bfr, uid, div1_halign, scratch_bfr.XtoAryAndClear(), div2_content);
	}	private static final byte[] Bry_style_bgn = Bry_.new_ascii_("style=\"width:"), Bry_style_end = Bry_.new_ascii_("px;\"");
	protected Bry_fmtr fmtr_thumb_core = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last	// REF.MW: Linker.php|makeImageLink2
	( "<div class=\"thumb t~{div1_halign}\">"
	, "  <div id=\"xowa_file_div_~{uid}\" class=\"thumbinner\" ~{style}>"
	, "~{div2_content}"
	, "  </div>"
	, "</div>"
	, ""
	), "uid", "div1_halign", "style", "div2_content"
	);
	public byte[] Html_thumb_part_img(Bry_bfr tmp_bfr, Xoa_page page, Xof_xfer_itm xfer_itm, Xop_lnki_tkn lnki, int uid, byte[] a_href, byte[] img_src, byte[] img_alt) {
		Html_thumb_part_img(tmp_bfr, page, xfer_itm, uid, a_href, lnki.Ttl().Page_txt(), xfer_itm.Html_w(), xfer_itm.Html_h(), img_src, img_alt);
		return tmp_bfr.XtoAryAndClear();
	}
	public void Html_thumb_part_img(Bry_bfr tmp_bfr, Xoa_page page, Xof_xfer_itm xfer_itm, int uid, byte[] a_href, byte[] a_title, int img_w, int img_h, byte[] img_src, byte[] img_alt) {
		fmtr_thumb_part_img.Bld_bfr_many(tmp_bfr, uid, a_href, a_title, arg_img_core.Init(uid, img_src, img_w, img_h), img_alt);
	}
	private Bry_fmtr fmtr_thumb_part_img = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( ""
	, "      <div>" 
	, "        <a href=\"~{a_href}\" class=\"image\" title=\"~{a_title}\">"
	, "          <img id=\"xowa_file_img_~{uid}\"~{img_core} alt=\"~{img_alt}\" />"
	, "        </a>"
	, "      </div>"
	), "uid", "a_href", "a_title", "img_core", "img_alt");

	public void Html_thumb_part_caption(Bry_bfr tmp_bfr, byte[] magnify_btn, Bry_fmtr_arg caption) {fmtr_thumb_part_caption.Bld_bfr_many(tmp_bfr, magnify_btn, caption);}
	private Bry_fmtr fmtr_thumb_part_caption = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( ""
	, "    <div class=\"thumbcaption\">~{magnify_btn}"
	, "      ~{caption}"
	, "    </div>"
	), "magnify_btn", "caption");

	public void Html_thumb_file_image(Bry_bfr tmp_bfr, byte[] thumb_image, byte[] caption, byte[] alt) {fmtr_thumb_file_image.Bld_bfr_many(tmp_bfr, thumb_image, caption, alt);}
	private Bry_fmtr fmtr_thumb_file_image = Bry_fmtr.new_("    ~{thumb_image}~{caption}~{alt}", "thumb_image", "caption", "alt");

	public void Html_thumb_file_audio(Bry_bfr tmp_bfr, byte[] caption, byte[] alt, byte[] play_btn, byte[] audio_info) {fmtr_thumb_file_audio.Bld_bfr_many(tmp_bfr, caption, alt, play_btn, audio_info);}
	private Bry_fmtr fmtr_thumb_file_audio = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( "    <div id=\"xowa_media_div\">~{play_btn}~{audio_info}"
	, "    </div>~{caption}~{alt}"
	), "caption", "alt", "play_btn", "audio_info");

	public void Html_thumb_file_video(Bry_bfr tmp_bfr, byte[] play_btn, byte[] video_thumb, byte[] caption, byte[] alt) {fmtr_thumb_file_video.Bld_bfr_many(tmp_bfr, caption, alt, play_btn, video_thumb);}
	private Bry_fmtr fmtr_thumb_file_video = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( "    <div id=\"xowa_media_div\">~{video_thumb}~{play_btn}"
	, "    </div>~{caption}~{alt}"
	), "caption", "alt", "play_btn", "video_thumb");

	public void Html_thumb_part_alt(Bry_bfr tmp_bfr, byte[] alt_html) {fmtr_thumb_part_alt.Bld_bfr_many(tmp_bfr, alt_html);}
	public Bry_fmtr Html_thumb_part_alt_fmtr() {return fmtr_thumb_part_alt;} private Bry_fmtr fmtr_thumb_part_alt = Bry_fmtr.new_
	(String_.Concat_lines_nl_skip_last
	( ""
	, "    <hr/>"
	, "    <div class=\"thumbcaption\">"
	, "~{html}"
	, "    </div>"
	), "html");

	@gplx.Virtual public void Html_thumb_part_magnify(Bry_bfr tmp_bfr, int uid, byte[] a_href, byte[] a_title, byte[] img_src) {
		fmtr_thumb_part_magnify.Bld_bfr_many(tmp_bfr, a_href, a_title, img_src);
	}
	private Bry_fmtr fmtr_thumb_part_magnify = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( ""
	, "      <div class=\"magnify\">"
	, "        <a href=\"~{a_href}\" class=\"internal\" title=\"~{a_title}\">"
	, "          <img src=\"~{img_src}\" width=\"15\" height=\"11\" alt=\"\" />"
	, "        </a>"
	, "      </div>"
	), "a_href", "a_title", "img_src");

	@gplx.Virtual public void Html_thumb_part_info(Bry_bfr tmp_bfr, int uid, byte[] a_href, byte[] img_src) {fmtr_thumb_part_info.Bld_bfr_many(tmp_bfr, a_href, img_src);}
	private Bry_fmtr fmtr_thumb_part_info = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( ""
	, "      <div>" 
	, "        <a href=\"~{a_href}\" class=\"image\" title=\"About this file\">"
	, "          <img src=\"~{img_src}\" width=\"22\" height=\"22\" />" 
	, "        </a>" 
	, "      </div>" 
	), "a_href", "img_src");

	@gplx.Virtual public void Html_thumb_part_play(Bry_bfr tmp_bfr, int uid, int a_width, int a_max_width, byte[] a_href, byte[] a_xowa_title, byte[] img_src) {
		fmtr_thumb_part_play.Bld_bfr_many(tmp_bfr, uid, a_width, a_max_width, a_href, a_xowa_title, img_src);
	}
	private Bry_fmtr fmtr_thumb_part_play = Bry_fmtr.new_(String_.Concat_lines_nl_skip_last
	( ""
	, "      <div>" 
	, "        <a id=\"xowa_file_play_~{uid}\" href=\"~{a_href}\" xowa_title=\"~{a_xowa_title}\" class=\"xowa_anchor_button\" style=\"width:~{a_width}px;max-width:~{a_max_width}px;\">"
	, "          <img src=\"~{img_src}\" width=\"22\" height=\"22\" alt=\"Play sound\" />" 
	, "        </a>" 
	, "      </div>"
	), "uid", "a_width", "a_max_width", "a_href", "a_xowa_title", "img_src");

        public static final Xoh_file_html_fmtr__base Base = new Xoh_file_html_fmtr__base();
}
interface Xoh_arg_img_core extends Bry_fmtr_arg {
	Xoh_arg_img_core Init(int uid, byte[] src, int w, int h);
}
class Xoh_arg_img_core__hdump implements Xoh_arg_img_core {
	private int uid;
	public Xoh_arg_img_core Init(int uid, byte[] img_src, int img_w, int img_h) {
		this.uid = uid;
		return this;
	}
	public void XferAry(Bry_bfr bfr, int idx) {
		bfr.Add_str(" xowa_img='");
		bfr.Add_int_variable(uid);
		bfr.Add_str("'");
//			Xoh_file_html_fmtr__hdump.Write_fmt(bfr, Hdump_html_fmtr__body.Key_img, uid);
	}
}
class Xoh_arg_img_core__basic implements Xoh_arg_img_core {
	private byte[] src; private int w, h;
	public Xoh_arg_img_core Init(int uid, byte[] src, int w, int h) {this.src = src; this.w = w; this.h = h; return this;}
	public void XferAry(Bry_bfr bfr, int idx) {
		fmtr_img_atrs.Bld_bfr_many(bfr, src, w, h);
	}
	private Bry_fmtr fmtr_img_atrs = Bry_fmtr.new_(" src=\"~{img_src}\" width=\"~{img_w}\" height=\"~{img_h}\"", "img_src", "img_w", "img_h");
}