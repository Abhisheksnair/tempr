package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.gif_search.GifCacheItemSerializable;
import com.whatsapp.gif_search.b;
import com.whatsapp.gif_search.h.b;
import com.whatsapp.gif_search.h.d;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.videoplayback.VideoSurfaceView;
import java.io.File;
import java.util.ArrayList;

public class GifVideoPreviewActivity
  extends nh
{
  vg n;
  final aoj o = aoj.a();
  final vp p = vp.a();
  String q;
  ImageView r;
  View s;
  private final com.whatsapp.emoji.h t = com.whatsapp.emoji.h.a();
  private final e u = e.a();
  private com.whatsapp.gif_search.h v;
  
  public static Intent a(Activity paramActivity, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    return new Intent(paramActivity, GifVideoPreviewActivity.class).putExtra("preview_media_url", paramString1).putExtra("media_url", paramString2).putExtra("static_preview_url", paramString3).putExtra("jids", paramArrayList).putExtra("send", paramBoolean2).putExtra("provider", paramInt1).putExtra("number_from_url", paramBoolean1).putExtra("origin", paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("gifvideopreview/create");
    super.onCreate(paramBundle);
    i().a(true);
    i().a();
    setTitle(2131297659);
    View localView = al.a(this.aq, getLayoutInflater(), 2130903242, null, false);
    setContentView(localView);
    this.q = getIntent().getStringExtra("file_path");
    paramBundle = getIntent().getStringExtra("jid");
    Object localObject3;
    int i;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramBundle))
    {
      g(this.u.d(paramBundle).a(this));
      localObject3 = (View)a.d.a(findViewById(2131755795));
      this.s = findViewById(2131755408);
      this.r = ((ImageView)findViewById(2131755794));
      i = MediaData.toGifAttribution(getIntent().getIntExtra("provider", 0));
      localObject4 = (VideoSurfaceView)a.d.a((VideoSurfaceView)findViewById(2131755424));
      ((View)a.d.a(findViewById(2131755437))).setOnClickListener(pk.a(this, (VideoSurfaceView)localObject4, i));
      ((VideoSurfaceView)localObject4).setOnPreparedListener(pl.a());
      if (TextUtils.isEmpty(this.q)) {
        break label412;
      }
      ((VideoSurfaceView)localObject4).setVideoPath(this.q);
      ((VideoSurfaceView)localObject4).start();
      ((View)localObject3).setVisibility(8);
      this.s.setVisibility(8);
      this.r.setVisibility(8);
      localObject1 = this.aq;
      localObject2 = this.t;
      localObject3 = this.aE;
      localObject4 = this.aQ;
      if (!TextUtils.isEmpty(paramBundle)) {
        break label665;
      }
    }
    label412:
    label486:
    label642:
    label665:
    for (paramBundle = null;; paramBundle = this.u.d(paramBundle))
    {
      this.n = new vg(this, (pv)localObject1, (com.whatsapp.emoji.h)localObject2, (and)localObject3, (atv)localObject4, localView, paramBundle, getIntent().getStringExtra("caption"), getIntent().getStringArrayListExtra("mentions"));
      return;
      localObject1 = getIntent().getStringArrayListExtra("jids");
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        if (((ArrayList)localObject1).size() == 1)
        {
          paramBundle = (String)((ArrayList)localObject1).get(0);
          g(this.u.d(paramBundle).a(this));
          break;
        }
        g(u.a.a(2131230720, ((ArrayList)localObject1).size(), new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) }));
      }
      break;
      localObject2 = getIntent().getStringExtra("media_url");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        Log.e("neither file path nor media url provided");
        finish();
        return;
      }
      ((View)localObject3).setVisibility(0);
      this.r.setVisibility(0);
      this.v = com.whatsapp.gif_search.h.a();
      localObject1 = getIntent().getStringExtra("preview_media_url");
      if (localObject1 != null)
      {
        localObject1 = this.v.a((String)localObject1);
        if (localObject1 == null) {
          break label642;
        }
        localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, ag.a);
        this.r.setImageBitmap((Bitmap)localObject1);
      }
      for (;;)
      {
        localObject1 = this.v;
        localObject3 = new pm(this, (View)localObject3, (VideoSurfaceView)localObject4);
        a.d.b();
        localObject4 = ((com.whatsapp.gif_search.h)localObject1).c.d;
        GifCacheItemSerializable localGifCacheItemSerializable = ((b)localObject4).a((String)localObject2);
        if ((localGifCacheItemSerializable != null) && (localGifCacheItemSerializable.getFile().exists()) && (localGifCacheItemSerializable.thumbnail != null)) {
          ((h.d)localObject3).a((String)localObject2, localGifCacheItemSerializable.getFile(), localGifCacheItemSerializable.thumbnail);
        }
        d.a(((com.whatsapp.gif_search.h)localObject1).a, new h.b(((com.whatsapp.gif_search.h)localObject1).d, ((com.whatsapp.gif_search.h)localObject1).e, ((com.whatsapp.gif_search.h)localObject1).f, (String)localObject2, i, ((com.whatsapp.gif_search.h)localObject1).b, (b)localObject4, (h.d)localObject3), new Void[0]);
        break;
        localObject1 = null;
        break label486;
        this.v.a(getIntent().getStringExtra("static_preview_url"), this.r);
      }
    }
  }
  
  public void onDestroy()
  {
    Log.i("gifvideopreview/destroy");
    super.onDestroy();
    if (this.n != null)
    {
      vg localvg = this.n;
      localvg.a.getViewTreeObserver().removeGlobalOnLayoutListener(localvg.g);
      localvg.e.a();
      this.n = null;
    }
    if (this.v != null) {
      this.v.b();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/GifVideoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */