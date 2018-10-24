package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.text.BidiFormatter;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.k;
import com.whatsapp.protocol.s;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.bc;
import com.whatsapp.util.bc.a;
import java.io.File;
import java.util.Locale;

public final class ConversationRowVideo
  extends jm
{
  private static Handler ak;
  private final TextView O;
  private final RowVideoView P;
  private final TextView Q;
  private final CircularProgressBar R;
  private final FrameLayout S;
  private final FrameLayout aa;
  private final ImageView ab;
  private final ImageView ac;
  private final View ad;
  private final TextEmojiLabel ae;
  private final View af;
  private final oz ag;
  private final ag ah;
  private ag.a ai;
  private a aj;
  private at al;
  
  public ConversationRowVideo(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (isInEditMode())
    {
      paramContext = null;
      this.ag = paramContext;
      if (!isInEditMode()) {
        break label283;
      }
    }
    label283:
    for (paramContext = (Context)localObject;; paramContext = ag.a())
    {
      this.ah = paramContext;
      this.ai = new ag.a()
      {
        public final int a()
        {
          View localView = ((Activity)ConversationRowVideo.this.getContext()).getWindow().getDecorView();
          return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
        }
        
        public final void a(View paramAnonymousView)
        {
          ConversationRowVideo.a(ConversationRowVideo.this).setImageDrawable(new ColorDrawable(-7829368));
        }
        
        public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
        {
          if (paramAnonymousBitmap != null)
          {
            ConversationRowVideo.a(ConversationRowVideo.this).setImageDrawable(new BitmapDrawable(ConversationRowVideo.this.getContext().getResources(), paramAnonymousBitmap));
            ConversationRowVideo.a(ConversationRowVideo.this).a(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), false);
            return;
          }
          ConversationRowVideo.a(ConversationRowVideo.this).setImageDrawable(new ColorDrawable(b.c(ConversationRowVideo.this.getContext(), 2131624003)));
        }
      };
      this.al = new at()
      {
        public final void a(View paramAnonymousView)
        {
          MediaData localMediaData = ConversationRowVideo.this.a.b();
          if (localMediaData.suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES) {
            ConversationRowVideo.this.l.b(ConversationRowVideo.this.getContext(), 2131296830, 1);
          }
          do
          {
            return;
            ConversationRowVideo.this.T.a(paramAnonymousView);
          } while (ConversationRowVideo.this.a.p == null);
          if (localMediaData.streamViewable)
          {
            ConversationRowVideo.b(ConversationRowVideo.this);
            return;
          }
          Log.e("streamdownload/unable to open playback");
        }
      };
      this.O = ((TextView)findViewById(2131755580));
      this.P = ((RowVideoView)findViewById(2131755327));
      this.R = ((CircularProgressBar)findViewById(2131755238));
      this.Q = ((TextView)findViewById(2131755493));
      this.aa = ((FrameLayout)findViewById(2131755643));
      this.ab = ((ImageView)findViewById(2131755644));
      this.ac = ((ImageView)findViewById(2131755642));
      this.S = ((FrameLayout)findViewById(2131755641));
      this.ad = findViewById(2131755579);
      this.ae = ((TextEmojiLabel)findViewById(2131755436));
      this.ae.setLinkHandler(new th());
      this.af = findViewById(2131755614);
      this.R.setMax(100);
      this.R.setProgressBarBackgroundColor(0);
      this.R.setPaintStrokeFactor(6.0F);
      int i = getResources().getDimensionPixelSize(2131361941);
      this.R.setPadding(i, i, i, i);
      if (ak == null) {
        i = Build.VERSION.SDK_INT;
      }
      c(true);
      return;
      paramContext = oz.a();
      break;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    MediaData localMediaData = this.a.b();
    this.Q.setVisibility(8);
    this.P.setKeepRatio(this.d);
    this.P.setFullWidth(this.d);
    ab.a(this.P, b(this.a));
    ab.a(this.n, c(this.a));
    if (this.o != null) {
      ab.a(this.o, d(this.a));
    }
    int i;
    Object localObject1;
    label183:
    label291:
    label346:
    Object localObject2;
    if (this.d)
    {
      i = ag.a(this.a, aoa.a().l);
      localObject1 = this.P;
      int j = aoa.a().l;
      if (i > 0) {
        ((RowVideoView)localObject1).a(j, i, true);
      }
    }
    else
    {
      this.ab.setOnClickListener(this.W);
      this.aa.setOnClickListener(this.W);
      if ((!localMediaData.transferring) || (localMediaData.prefetching)) {
        break label648;
      }
      f();
      if (paramBoolean) {
        break label643;
      }
      paramBoolean = true;
      a(true, paramBoolean, true, this.ad, this.R, this.ac, this.O);
      this.ad.setVisibility(0);
      this.P.setVisibility(0);
      this.S.setVisibility(0);
      this.Q.setVisibility(8);
      localObject1 = this.a.e;
      this.P.setOnClickListener(this.W);
      this.O.setOnClickListener(this.V);
      this.R.setOnClickListener(this.V);
      this.S.setOnClickListener(this.V);
      g();
      if ((!this.a.e.b) || (this.a.g().b()) || (localMediaData.transferred) || (localMediaData.file != null)) {
        break label1260;
      }
      this.aa.setVisibility(8);
      this.P.setOnLongClickListener(this.u);
      localObject2 = this.P;
      if (!this.a.e.b) {
        break label1271;
      }
      localObject1 = ConversationRowImage.P;
      label381:
      ((RowVideoView)localObject2).setFrameDrawable((Drawable)localObject1);
      this.ah.a(this.a, this.P, this.ai);
      if (ak != null)
      {
        if (this.aj != null)
        {
          ak.removeCallbacks(this.aj);
          this.aj.a();
        }
        this.aj = new a(localMediaData);
        ak.postDelayed(this.aj, 2000L);
      }
      if (this.a.w == 0) {
        this.a.w = MediaFileUtils.b(localMediaData.file);
      }
      if (this.a.w == 0) {
        break label1279;
      }
      localObject1 = DateUtils.formatElapsedTime(this.a.w);
      label513:
      if (this.Q.getVisibility() == 0)
      {
        this.Q.setText((CharSequence)localObject1);
        if (!this.l.d()) {
          break label1297;
        }
        this.Q.setCompoundDrawablesWithIntrinsicBounds(2130840345, 0, 0, 0);
      }
      label555:
      if (this.n != null)
      {
        if ((!this.a.E) || (!this.a.e.b) || (cs.e(this.a.e.a))) {
          break label1330;
        }
        this.n.setCompoundDrawablesWithIntrinsicBounds(2130837657, 0, 0, 0);
      }
    }
    for (;;)
    {
      a(this.af, this.ae);
      return;
      i = aoa.a().l * 9 / 16;
      break;
      label643:
      paramBoolean = false;
      break label183;
      label648:
      if ((localMediaData.transferred) || ((this.a.E) && (this.a.e.b) && (!j.b(this.a.e.a))))
      {
        e();
        a(false, false, true, this.ad, this.R, this.ac, this.O);
        this.O.setVisibility(8);
        this.P.setVisibility(0);
        this.ad.setVisibility(8);
        this.Q.setVisibility(0);
        this.O.setOnClickListener(this.W);
        this.P.setOnClickListener(this.W);
        this.S.setVisibility(8);
        break label291;
      }
      this.ad.setVisibility(0);
      this.O.setVisibility(0);
      this.S.setVisibility(0);
      this.ac.setVisibility(8);
      this.Q.setVisibility(8);
      if ((this.a.e.b) && (localMediaData.file != null))
      {
        this.O.setText(2131297619);
        this.O.setContentDescription(getResources().getString(2131297619));
        this.O.setCompoundDrawablesWithIntrinsicBounds(2130840271, 0, 0, 0);
        this.O.setOnClickListener(this.U);
        this.S.setOnClickListener(this.U);
        this.P.setOnClickListener(this.W);
        f();
        if (paramBoolean) {
          break label1255;
        }
      }
      label986:
      label1122:
      label1255:
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(false, paramBoolean, true, this.ad, this.R, this.ac, this.O);
        break;
        TextView localTextView = this.O;
        localObject1 = u.a();
        long l1;
        long l2;
        if (localMediaData.showDownloadedBytes)
        {
          l1 = localMediaData.cachedDownloadedBytes;
          l2 = this.a.t;
          localObject2 = bc.a(((Context)localObject1).getResources(), l2);
          if (localObject2 != null) {
            break label1122;
          }
          localObject1 = Formatter.formatShortFileSize((Context)localObject1, l2);
        }
        for (;;)
        {
          localTextView.setText((CharSequence)localObject1);
          this.O.setContentDescription(getResources().getString(2131296368));
          this.O.setCompoundDrawablesWithIntrinsicBounds(2130840266, 0, 0, 0);
          this.O.setOnClickListener(this.T);
          this.S.setOnClickListener(this.T);
          this.P.setOnClickListener(this.al);
          this.ab.setOnClickListener(this.al);
          this.aa.setOnClickListener(this.al);
          break;
          l1 = 0L;
          break label986;
          Object localObject3 = bc.a(l1, bc.a(l2));
          if (((Float)((Pair)localObject3).first).floatValue() < 0.1D)
          {
            localObject1 = Formatter.formatShortFileSize((Context)localObject1, l2);
          }
          else
          {
            localObject2 = ((Context)localObject1).getString(2131296794, new Object[] { ((Pair)localObject3).second, ((bc.a)localObject2).a, ((bc.a)localObject2).b });
            localObject3 = ((Context)localObject1).getResources().getConfiguration().locale;
            localObject1 = localObject2;
            if (Build.VERSION.SDK_INT >= 18)
            {
              localObject1 = localObject2;
              if (TextUtils.getLayoutDirectionFromLocale((Locale)localObject3) == 1) {
                localObject1 = BidiFormatter.getInstance(true).unicodeWrap((String)localObject2);
              }
            }
          }
        }
      }
      label1260:
      this.aa.setVisibility(0);
      break label346;
      label1271:
      localObject1 = ConversationRowImage.O;
      break label381;
      label1279:
      localObject1 = Formatter.formatShortFileSize(u.a(), this.a.t);
      break label513;
      label1297:
      this.Q.setCompoundDrawablesWithIntrinsicBounds(null, null, new az(getContext().getResources().getDrawable(2130840345)), null);
      break label555;
      label1330:
      this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  private void q()
  {
    int i;
    if (this.c)
    {
      i = 3;
      if (!aic.U) {
        break label52;
      }
    }
    label52:
    for (Intent localIntent = MediaView.a(this.a, this.a.e.a, getContext(), i);; localIntent = VideoDownloadStreamActivity.a(this.a, getContext(), i))
    {
      getContext().startActivity(localIntent);
      return;
      i = 1;
      break;
    }
  }
  
  protected final int a(int paramInt)
  {
    int j;
    if (!TextUtils.isEmpty(this.a.z))
    {
      j = super.a(paramInt);
      return j;
    }
    int i;
    if (s.a(paramInt, 13) >= 0) {
      i = 2130840358;
    }
    for (;;)
    {
      j = i;
      if (!av.d()) {
        break;
      }
      j = i;
      if (paramInt != 7) {
        break;
      }
      return 2130840370;
      if (s.a(paramInt, 5) >= 0) {
        i = 2130840362;
      } else if (s.a(paramInt, 4) == 0) {
        i = 2130840360;
      } else {
        i = 2130840370;
      }
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (bool)) {
        c(bool);
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final void b()
  {
    int i = 1;
    Object localObject1 = this.a.b();
    if (((MediaData)localObject1).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES) {
      this.l.b(getContext(), 2131296830, 1);
    }
    do
    {
      do
      {
        return;
        if ((!this.a.e.b) && (((MediaData)localObject1).transferring) && (((MediaData)localObject1).downloader != null) && (((MediaData)localObject1).downloader.g != null))
        {
          q();
          return;
        }
      } while ((!this.a.e.b) && (!((MediaData)localObject1).transferred));
      if ((this.a.e.b) && (!((MediaData)localObject1).transferred) && (!((MediaData)localObject1).transcoded) && (((MediaData)localObject1).doodleId != null) && (MediaFileUtils.a(this.ag, ((MediaData)localObject1).doodleId).exists()))
      {
        this.l.b(getContext(), 2131296400, 1);
        return;
      }
      boolean bool = false;
      if (((MediaData)localObject1).file != null) {
        bool = new File(Uri.fromFile(((MediaData)localObject1).file).getPath()).exists();
      }
      Log.i("viewmessage/ from_me:" + this.a.e.b + " type:" + this.a.s + " name:" + this.a.y + " url:" + MediaFileUtils.a(this.a.p) + " file:" + ((MediaData)localObject1).file + " progress:" + ((MediaData)localObject1).progress + " transferred:" + ((MediaData)localObject1).transferred + " transferring:" + ((MediaData)localObject1).transferring + " fileSize:" + ((MediaData)localObject1).fileSize + " media_size:" + this.a.t + " timestamp:" + this.a.n);
      if (bool) {
        break label491;
      }
      Log.w("viewmessage/ no file");
      if (!this.c) {
        break;
      }
      localObject1 = getContext();
    } while (!(localObject1 instanceof nh));
    this.l.a((nh)localObject1);
    return;
    localObject1 = new Intent(getContext(), MediaGallery.class);
    ((Intent)localObject1).putExtra("pos", -1);
    ((Intent)localObject1).putExtra("alert", true);
    ((Intent)localObject1).putExtra("jid", this.a.e.a);
    ((Intent)localObject1).putExtra("key", this.a.e.hashCode());
    getContext().startActivity((Intent)localObject1);
    return;
    label491:
    if (this.c)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (aic.T))
      {
        localObject1 = MediaView.a(this.a, this.a.e.a, getContext(), 3);
        ((Intent)localObject1).putExtra("nogallery", true);
        getContext().startActivity((Intent)localObject1);
        return;
      }
      Object localObject2 = new Intent("android.intent.action.VIEW");
      ((Intent)localObject2).setDataAndType(MediaProvider.a(this.a), "video/*");
      ((Intent)localObject2).setFlags(1);
      pv.a(getContext(), (Intent)localObject2);
      localObject2 = getContext();
      if (this.a.e.b) {
        i = 3;
      }
      pb.a((Context)localObject2, i, 3, this.a.w, ((MediaData)localObject1).file);
      return;
    }
    localObject1 = MediaView.a(this.a, this.a.e.a, getContext(), 1);
    getContext().startActivity((Intent)localObject1);
  }
  
  public final void g()
  {
    int i = a(this.R, this.a.b());
    CircularProgressBar localCircularProgressBar = this.R;
    if (i == 0) {}
    for (i = b.c(getContext(), 2131624070);; i = b.c(getContext(), 2131624069))
    {
      localCircularProgressBar.setProgressBarColor(i);
      return;
    }
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903172;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903172;
  }
  
  final int getMainChildMaxWidth()
  {
    View localView = ((Activity)getContext()).getWindow().getDecorView();
    return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903173;
  }
  
  protected final int getStarDrawable()
  {
    if (TextUtils.isEmpty(this.a.z)) {
      return 2130840366;
    }
    return super.getStarDrawable();
  }
  
  public final void i()
  {
    c(false);
    super.i();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((ak != null) && (this.aj == null))
    {
      this.aj = new a(this.a.b());
      ak.postDelayed(this.aj, 2000L);
    }
  }
  
  public static class RowVideoView
    extends ImageView
  {
    private boolean a;
    private boolean b;
    private Paint c = new Paint(1);
    private RectF d = new RectF();
    private Shader e;
    private int f;
    private int g;
    private Drawable h;
    
    public RowVideoView(Context paramContext)
    {
      super();
    }
    
    public RowVideoView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public RowVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if ((this.f <= 0) || (this.g <= 0) || (paramBoolean))
      {
        this.f = paramInt1;
        this.g = paramInt2;
      }
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      if (isInEditMode()) {}
      do
      {
        return;
        float f1 = aoa.a().a;
        int i = getWidth();
        this.c.setColor(1711276032);
        this.c.setShader(this.e);
        this.c.setStyle(Paint.Style.FILL);
        this.d.set(0.0F, getHeight() - f1 * 24.0F * 4.0F / 3.0F, i, getHeight());
        paramCanvas.drawRect(this.d, this.c);
      } while ((this.h == null) || (this.b));
      this.h.setBounds(0, 0, getWidth(), getHeight());
      this.h.draw(paramCanvas);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      if (isInEditMode())
      {
        if (this.a)
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
        setMeasuredDimension(600, 600);
        return;
      }
      View localView = ((Activity)getContext()).getWindow().getDecorView();
      if (this.b)
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt1);
        if (View.MeasureSpec.getMode(paramInt1) == 0) {
          break label163;
        }
        paramInt2 = Math.min(paramInt2, View.MeasureSpec.getSize(paramInt1));
      }
      label163:
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2)
      {
        if (this.a)
        {
          if ((!(getDrawable() instanceof ColorDrawable)) && (getDrawable() != null)) {
            a(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight(), false);
          }
          paramInt2 = (int)(paramInt1 / this.f * this.g);
        }
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        paramInt2 = Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
        break;
      }
    }
    
    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (isInEditMode()) {
        return;
      }
      float f1 = aoa.a().a;
      this.e = new LinearGradient(0.0F, paramInt2 - 24.0F * f1 * 4.0F / 3.0F, 0.0F, paramInt2, 0, -16777216, Shader.TileMode.CLAMP);
    }
    
    public void setFrameDrawable(Drawable paramDrawable)
    {
      this.h = paramDrawable;
    }
    
    public void setFullWidth(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public void setKeepRatio(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
  
  final class a
    implements Runnable
  {
    MediaData a;
    long b = 1000000L;
    Drawable c;
    long d;
    
    a(MediaData paramMediaData)
    {
      this.a = paramMediaData;
    }
    
    final void a()
    {
      ConversationRowVideo.p().post(new jt(this));
      ConversationRowVideo.this.post(new ju(this));
    }
    
    public final void run()
    {
      if ((this.a == null) || (this.a != ConversationRowVideo.this.a.b()) || (!ConversationRowVideo.this.isShown()) || (ConversationRowVideo.c(ConversationRowVideo.this) != this) || (this.a.file == null) || (!this.a.file.exists()))
      {
        a();
        return;
      }
      long l = ConversationRowVideo.this.getDrawingTime();
      if (this.d == l)
      {
        a();
        return;
      }
      this.d = l;
      int n = 0;
      int i1 = 0;
      int m = 0;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      i = n;
      j = i1;
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(this.a.file.getAbsolutePath());
          i = n;
          j = i1;
          Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(this.b);
          i = n;
          j = i1;
          l = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
          k = m;
          if (l > 2000L)
          {
            i = n;
            j = i1;
            if (this.b <= l * 1000L) {
              continue;
            }
            i = n;
            j = i1;
            this.b = 0L;
            k = m;
            if (localBitmap != null)
            {
              k = m;
              i = n;
              j = i1;
              if (this.a == ConversationRowVideo.this.a.b())
              {
                k = m;
                i = n;
                j = i1;
                if (ConversationRowVideo.this.isShown())
                {
                  i = 1;
                  j = 1;
                  k = 1;
                  ConversationRowVideo.this.post(new js(this, localBitmap));
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("videopreview/getvideothumb" + localException.toString());
          int k = i;
          continue;
          a();
          return;
        }
        catch (NoSuchMethodError localNoSuchMethodError)
        {
          i = j;
          continue;
        }
        localMediaMetadataRetriever.release();
        if (k == 0) {
          continue;
        }
        ConversationRowVideo.p().postDelayed(this, 2000L);
        return;
        i = n;
        j = i1;
        this.b += 1000000L;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ConversationRowVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */