package com.whatsapp;

import a.a.a.a.a.a.d;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.a;
import android.support.v4.app.c;
import android.support.v4.content.b;
import android.support.v4.f.h;
import android.support.v4.view.ab;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.at;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.Iterator;

public final class ConversationRowAlbum
  extends hy
{
  final ag.a O;
  protected at P;
  protected at Q;
  protected at R;
  private ArrayList<j> S;
  private final ArrayList<a> T = new ArrayList();
  private final TextView U;
  private final TextView V;
  private final CircularProgressBar W;
  private final ImageView aa;
  private final View ab;
  private final vx ac;
  private final vs ad;
  
  public ConversationRowAlbum(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    label44:
    boolean bool;
    if (isInEditMode())
    {
      paramContext = null;
      this.ac = paramContext;
      if (!isInEditMode()) {
        break label334;
      }
      paramContext = localContext;
      this.ad = paramContext;
      this.O = new ag.a()
      {
        public final int a()
        {
          View localView = ((Activity)ConversationRowAlbum.this.getContext()).getWindow().getDecorView();
          return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
        }
        
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = (ImageView)paramAnonymousView;
          paramAnonymousView.setImageDrawable(null);
          paramAnonymousView.setBackgroundColor(-7829368);
        }
        
        public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
        {
          paramAnonymousView = (ImageView)paramAnonymousView;
          if (paramAnonymousBitmap != null)
          {
            paramAnonymousView.setImageBitmap(paramAnonymousBitmap);
            return;
          }
          paramAnonymousView.setImageResource(2130840347);
        }
      };
      this.P = new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = ConversationRowAlbum.a(ConversationRowAlbum.this).iterator();
          while (paramAnonymousView.hasNext())
          {
            j localj = (j)paramAnonymousView.next();
            MediaData localMediaData = localj.b();
            if (localMediaData.transferring)
            {
              if (localj.e.b)
              {
                ConversationRowAlbum.b(ConversationRowAlbum.this).a(localj);
                ConversationRowAlbum.c(ConversationRowAlbum.this).a(localj);
                if (localMediaData.uploader != null) {
                  localMediaData.uploader.b(localj);
                }
              }
              if (localMediaData.downloader != null) {
                localMediaData.downloader.b();
              }
            }
          }
        }
      };
      this.Q = new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = ConversationRowAlbum.a(ConversationRowAlbum.this).iterator();
          while (paramAnonymousView.hasNext())
          {
            j localj = (j)paramAnonymousView.next();
            MediaData localMediaData = localj.b();
            if ((!localMediaData.transferred) && (!localMediaData.transferring)) {
              ConversationRowAlbum.this.x.a(localj, true);
            }
          }
        }
      };
      this.R = new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = ConversationRowAlbum.a(ConversationRowAlbum.this).iterator();
          while (paramAnonymousView.hasNext())
          {
            j localj = (j)paramAnonymousView.next();
            MediaData localMediaData = localj.b();
            if ((!localMediaData.transferred) && (!localMediaData.transferring) && (localj.p != null) && (localMediaData.suspiciousContent != MediaData.SUSPICIOUS_CONTENT_YES)) {
              ConversationRowAlbum.this.C.a((nh)ConversationRowAlbum.this.getContext(), localj);
            }
          }
        }
      };
      this.U = ((TextView)findViewById(2131755578));
      this.T.add(new a(findViewById(2131755574), 0));
      this.T.add(new a(findViewById(2131755575), 1));
      this.T.add(new a(findViewById(2131755576), 2));
      this.T.add(new a(findViewById(2131755577), 3));
      if (4 != this.T.size()) {
        break label341;
      }
      bool = true;
      label216:
      a.d.a(bool, "wrong number of views");
      this.V = ((TextView)findViewById(2131755580));
      this.W = ((CircularProgressBar)findViewById(2131755238));
      this.W.setProgressBarBackgroundColor(0);
      this.aa = ((ImageView)findViewById(2131755300));
      this.ab = findViewById(2131755579);
      paramContext = this.ab;
      localContext = getContext();
      if (!paramj.e.b) {
        break label347;
      }
    }
    label334:
    label341:
    label347:
    for (int i = 2131623981;; i = 2131623980)
    {
      paramContext.setBackgroundDrawable(new abm(b.c(localContext, i)));
      c(true);
      return;
      paramContext = vx.a();
      break;
      paramContext = vs.a();
      break label44;
      bool = false;
      break label216;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.S == null) {
      return;
    }
    int i = 0;
    while (i < 4)
    {
      ((a)this.T.get(i)).a((j)this.S.get(i));
      i += 1;
    }
    Object localObject = (a)this.T.get(3);
    if (this.S.size() > this.T.size())
    {
      this.U.setVisibility(0);
      this.U.setText(getContext().getString(2131297476, new Object[] { Integer.valueOf(this.S.size() - this.T.size() + 1) }));
      ((a)localObject).a(false);
      if (this.S == null) {
        break label276;
      }
      localObject = this.S.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((j)((Iterator)localObject).next()).b().transferring)
        {
          i = 1;
          label181:
          if (i == 0) {
            break label286;
          }
          this.ab.setVisibility(0);
          if (paramBoolean) {
            break label281;
          }
        }
      }
    }
    label276:
    label281:
    for (paramBoolean = true;; paramBoolean = false)
    {
      jm.a(true, paramBoolean, this.ab, this.W, this.aa, this.V);
      this.aa.setOnClickListener(this.P);
      this.V.setOnClickListener(this.P);
      this.W.setOnClickListener(this.P);
      g();
      return;
      this.U.setVisibility(8);
      ((a)localObject).a(true);
      break;
      i = 0;
      break label181;
    }
    label286:
    if (this.S != null)
    {
      localObject = this.S.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((j)((Iterator)localObject).next()).b().transferred);
    }
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label375;
      }
      this.ab.setVisibility(8);
      jm.a(false, false, this.ab, this.W, this.aa, this.V);
      break;
    }
    label375:
    this.ab.setVisibility(0);
    label389:
    label423:
    j localj;
    MediaData localMediaData;
    int k;
    if (!paramBoolean)
    {
      paramBoolean = true;
      jm.a(false, paramBoolean, this.ab, this.W, this.aa, this.V);
      localObject = this.S.iterator();
      j = 0;
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label532;
      }
      localj = (j)((Iterator)localObject).next();
      localMediaData = localj.b();
      if ((localMediaData.transferred) || (localMediaData.transferring)) {
        break label705;
      }
      k = i;
      if (localj.e.b)
      {
        k = i;
        if (localMediaData.file == null)
        {
          k = i;
          if (localj.p != null) {
            k = i + 1;
          }
        }
      }
      i = j + 1;
    }
    for (int j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break label423;
      paramBoolean = false;
      break label389;
      label532:
      if ((this.a.e.b) && (j != i))
      {
        this.V.setText(2131297619);
        this.V.setCompoundDrawablesWithIntrinsicBounds(2130837714, 0, 0, 0);
        this.V.setOnClickListener(this.Q);
        break;
      }
      localObject = this.S.iterator();
      i = 0;
      label598:
      if (((Iterator)localObject).hasNext())
      {
        localj = (j)((Iterator)localObject).next();
        localMediaData = localj.b();
        if ((localMediaData.transferred) || (localMediaData.transferring)) {
          break label702;
        }
        long l = i;
        i = (int)(localj.t + l);
      }
      label702:
      for (;;)
      {
        break label598;
        this.V.setText(Formatter.formatShortFileSize(u.a(), i));
        this.V.setCompoundDrawablesWithIntrinsicBounds(2130837663, 0, 0, 0);
        this.V.setOnClickListener(this.R);
        break;
      }
      label705:
      k = i;
      i = j;
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    super.a(this.a, paramBoolean);
    if (paramBoolean) {
      c(false);
    }
  }
  
  public final void a(ArrayList<j> paramArrayList, boolean paramBoolean)
  {
    if (this.a != paramArrayList.get(0)) {}
    boolean bool1;
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = paramBoolean;
      if (!paramBoolean)
      {
        if ((this.S != null) && (this.S.size() == paramArrayList.size())) {
          break;
        }
        bool1 = true;
      }
      this.S = paramArrayList;
      super.a((j)paramArrayList.get(0), bool1);
      if ((bool2) || (bool1)) {
        c(bool2);
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      bool1 = paramBoolean;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (this.S.get(i) != paramArrayList.get(i))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  public final boolean a(j.b paramb)
  {
    if (this.S == null) {
      return false;
    }
    Iterator localIterator = this.S.iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).e.equals(paramb)) {
        return true;
      }
    }
    return false;
  }
  
  protected final void c()
  {
    jz localjz = getRowsContainer();
    if (localjz != null)
    {
      localjz.a(this.a);
      Iterator localIterator = this.S.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (!localj.e.equals(this.a.e)) {
          localjz.b(localj);
        }
      }
    }
  }
  
  protected final void d()
  {
    if (isLongClickable())
    {
      jz localjz = getRowsContainer();
      if (localjz != null)
      {
        Iterator localIterator = this.S.iterator();
        while (localIterator.hasNext()) {
          localjz.b((j)localIterator.next());
        }
        this.q.setSelected(localjz.c(this.a));
      }
    }
  }
  
  public final void g()
  {
    boolean bool = false;
    int i = -1;
    Object localObject;
    int j;
    int k;
    if ((this.S != null) && (!this.S.isEmpty()))
    {
      localObject = this.S.iterator();
      j = 0;
      i = -1;
      if (((Iterator)localObject).hasNext())
      {
        MediaData localMediaData = ((j)((Iterator)localObject).next()).b();
        if ((!localMediaData.transferring) || (localMediaData.prefetching)) {
          break label266;
        }
        k = i;
        if (i < 0) {
          k = 0;
        }
        int m = (int)localMediaData.progress;
        i = m;
        if (localMediaData.transcoder != null)
        {
          i = m;
          if (localMediaData.transcoder.c()) {
            if (localMediaData.uploader != null) {
              break label153;
            }
          }
        }
        label153:
        for (i = m / 2;; i = m / 2 + 50)
        {
          m = j + 1;
          j = k + i;
          i = m;
          k = j;
          j = i;
          i = k;
          break;
        }
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        this.W.setVisibility(8);
        return;
      }
      i /= j;
      this.W.setVisibility(0);
      localObject = this.W;
      if ((i == 0) || (i == 100)) {
        bool = true;
      }
      ((CircularProgressBar)localObject).setIndeterminate(bool);
      this.W.setProgress(i);
      localObject = this.W;
      if (i == 0) {}
      for (i = b.c(getContext(), 2131623954);; i = b.c(getContext(), 2131623953))
      {
        ((CircularProgressBar)localObject).setProgressBarColor(i);
        return;
      }
      label266:
      k = i;
      i = j;
      j = k;
      break;
      j = 0;
    }
  }
  
  protected final int getCenteredLayoutId()
  {
    return 0;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903134;
  }
  
  final int getMainChildMaxWidth()
  {
    View localView = ((Activity)getContext()).getWindow().getDecorView();
    return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903135;
  }
  
  public final void i()
  {
    c(false);
    super.i();
  }
  
  public static class AlbumGridFrame
    extends FrameLayout
  {
    int a;
    
    public AlbumGridFrame(Context paramContext)
    {
      super();
      a(paramContext);
    }
    
    public AlbumGridFrame(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      a(paramContext);
    }
    
    public AlbumGridFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      a(paramContext);
    }
    
    @TargetApi(21)
    public AlbumGridFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      super(paramAttributeSet, paramInt1, paramInt2);
      a(paramContext);
    }
    
    private void a(Context paramContext)
    {
      this.a = paramContext.getResources().getDimensionPixelSize(2131361945);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      if (isInEditMode()) {}
      int i;
      View localView;
      for (paramInt2 = 800;; paramInt2 = Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100)
      {
        i = paramInt2;
        if (j != 0) {
          i = Math.min(paramInt2, View.MeasureSpec.getSize(paramInt1));
        }
        paramInt2 = View.MeasureSpec.makeMeasureSpec((i - this.a) / 2, 1073741824);
        paramInt1 = 0;
        while (paramInt1 < 4)
        {
          getChildAt(paramInt1).measure(paramInt2, paramInt2);
          paramInt1 += 1;
        }
        localView = ((Activity)getContext()).getWindow().getDecorView();
      }
      setMeasuredDimension(i, i);
    }
  }
  
  final class a
  {
    final ImageView a;
    final TextView b;
    final ImageView c;
    
    a(View paramView, final int paramInt)
    {
      this.a = ((ImageView)paramView.findViewById(2131755327));
      this.b = ((TextView)paramView.findViewById(2131755328));
      this.c = ((ImageView)paramView.findViewById(2131755329));
      this.a.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          Intent localIntent = new Intent(ConversationRowAlbum.this.getContext(), MediaAlbumActivity.class);
          paramAnonymousView = new long[ConversationRowAlbum.a(ConversationRowAlbum.this).size()];
          int i = 0;
          while (i < ConversationRowAlbum.a(ConversationRowAlbum.this).size())
          {
            paramAnonymousView[i] = ((j)ConversationRowAlbum.a(ConversationRowAlbum.this).get(i)).Q;
            i += 1;
          }
          localIntent.putExtra("message_ids", paramAnonymousView);
          Object localObject1;
          Object localObject2;
          if (!ConversationRowAlbum.this.a.e.b) {
            if ((qz.e(ConversationRowAlbum.this.a.e.a)) && (ConversationRowAlbum.this.a.f != null))
            {
              paramAnonymousView = ConversationRowAlbum.this.a.f;
              localIntent.putExtra("jid", paramAnonymousView);
              localIntent.putExtra("start_index", paramInt);
              localObject1 = (j)ConversationRowAlbum.a(ConversationRowAlbum.this).get(paramInt);
              paramAnonymousView = jm.b((j)localObject1);
              ab.a(ConversationRowAlbum.a.this.a, paramAnonymousView);
              paramAnonymousView = new h(ConversationRowAlbum.a.this.a, paramAnonymousView);
              localObject2 = jm.c((j)localObject1);
              ab.a(ConversationRowAlbum.a.this.b, (String)localObject2);
              localObject2 = new h(ConversationRowAlbum.a.this.b, localObject2);
              if (ConversationRowAlbum.a.this.b.getVisibility() != 8) {
                break label359;
              }
              paramAnonymousView = c.a((Activity)ConversationRowAlbum.this.getContext(), new h[] { paramAnonymousView });
            }
          }
          for (;;)
          {
            a.a(ConversationRowAlbum.this.getContext(), localIntent, paramAnonymousView.a());
            return;
            paramAnonymousView = ConversationRowAlbum.this.a.e.a;
            break;
            paramAnonymousView = null;
            break;
            label359:
            if (ConversationRowAlbum.a.this.c != null)
            {
              localObject1 = jm.d((j)localObject1);
              ab.a(ConversationRowAlbum.a.this.c, (String)localObject1);
              localObject1 = new h(ConversationRowAlbum.a.this.c, localObject1);
              paramAnonymousView = c.a((Activity)ConversationRowAlbum.this.getContext(), new h[] { paramAnonymousView, localObject2, localObject1 });
            }
            else
            {
              paramAnonymousView = c.a((Activity)ConversationRowAlbum.this.getContext(), new h[] { paramAnonymousView, localObject2 });
            }
          }
        }
      });
      this.a.setOnLongClickListener(ConversationRowAlbum.this.u);
    }
    
    final void a(j paramj)
    {
      this.b.setText(l.a(ConversationRowAlbum.this.getContext(), ConversationRowAlbum.this.v.a(paramj)));
      ConversationRowAlbum.this.L.a(paramj, this.a, ConversationRowAlbum.this.O, "album-" + paramj.e);
      int i;
      if ((paramj.e.b) && (this.c != null))
      {
        if (s.a(paramj.d, 13) < 0) {
          break label110;
        }
        i = 2130840358;
      }
      for (;;)
      {
        this.c.setImageResource(i);
        return;
        label110:
        if (s.a(paramj.d, 5) >= 0) {
          i = 2130840362;
        } else if (s.a(paramj.d, 4) == 0) {
          i = 2130840360;
        } else {
          i = 2130840370;
        }
      }
    }
    
    final void a(boolean paramBoolean)
    {
      int j = 0;
      Object localObject = this.b;
      if (paramBoolean)
      {
        i = 0;
        ((TextView)localObject).setVisibility(i);
        if (this.c != null)
        {
          localObject = this.c;
          if (!paramBoolean) {
            break label52;
          }
        }
      }
      label52:
      for (int i = j;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        return;
        i = 8;
        break;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ConversationRowAlbum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */