package com.whatsapp;

import a.a.a.a.d;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.a;
import com.whatsapp.data.cs;
import com.whatsapp.location.cc;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.at;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jk
  extends hy
{
  static a O;
  private static final Set<String> P;
  private static boolean ae;
  private final TextView Q;
  private final View R;
  private final View S;
  private final ImageView T;
  private final View U;
  private final TextEmojiLabel V;
  private final TextView W;
  private final TextView aa;
  private final View ab;
  private c ac;
  private final ag ad;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("www.facebook.com");
    localHashSet.add("maps.google.com");
    localHashSet.add("foursquare.com");
    P = Collections.unmodifiableSet(localHashSet);
  }
  
  jk(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = ag.a())
    {
      this.ad = paramContext;
      this.T = ((ImageView)findViewById(2131755327));
      this.U = findViewById(2131755625);
      this.Q = ((TextView)findViewById(2131755580));
      this.R = findViewById(2131755579);
      this.S = findViewById(2131755238);
      this.V = ((TextEmojiLabel)findViewById(2131755632));
      this.W = ((TextView)findViewById(2131755633));
      this.aa = ((TextView)findViewById(2131755634));
      this.ab = findViewById(2131755616);
      this.V.setLinkHandler(new th());
      this.V.setAutoLinkMask(0);
      this.V.setLinksClickable(false);
      this.V.setFocusable(false);
      this.V.setClickable(false);
      this.V.setLongClickable(false);
      q();
      return;
    }
  }
  
  private void q()
  {
    int i;
    final Object localObject3;
    Object localObject4;
    if ((this.a.C != 0.0D) || (this.a.B != 0.0D))
    {
      i = 1;
      if (i != 0)
      {
        this.U.setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            cc localcc;
            Context localContext;
            double d1;
            double d2;
            Object localObject;
            if (jk.this.a.e.b)
            {
              paramAnonymousView = u.a().getString(2131298216);
              localcc = jk.this.m;
              localContext = jk.this.getContext();
              d1 = jk.this.a.B;
              d2 = jk.this.a.C;
              localObject = paramAnonymousView;
              if (!TextUtils.isEmpty(paramAnonymousView)) {
                localObject = paramAnonymousView.replace("(", "[").replace(")", "]");
              }
              paramAnonymousView = "https://maps.google.com/maps?q=loc:" + d1 + "," + d2;
              if ((TextUtils.isEmpty((CharSequence)localObject)) || ((Build.VERSION.SDK_INT <= 10) && (localcc.d() >= 614050000))) {
                break label395;
              }
              paramAnonymousView = paramAnonymousView + " (" + (String)localObject + ")";
            }
            label395:
            for (;;)
            {
              localObject = Uri.parse(paramAnonymousView);
              paramAnonymousView = (View)localObject;
              if (NumberFormat.getInstance().format(1.1D).indexOf(",") > 0)
              {
                paramAnonymousView = (View)localObject;
                if (Build.VERSION.SDK_INT >= 14)
                {
                  paramAnonymousView = (View)localObject;
                  if (localcc.d() >= 700000000)
                  {
                    paramAnonymousView = (View)localObject;
                    if (localcc.d() < 702000000) {
                      paramAnonymousView = Uri.parse("https://maps.google.com/maps?q=loc:(" + d1 + "," + d2 + "&z=16");
                    }
                  }
                }
              }
              localContext.startActivity(new Intent("android.intent.action.VIEW", paramAnonymousView));
              return;
              if ((jk.this.a.e.a.contains("-")) && (jk.this.a.f != null))
              {
                paramAnonymousView = jk.this.F.d(jk.this.a.f).a(jk.this.getContext());
                break;
              }
              paramAnonymousView = jk.this.F.d(jk.this.a.e.a).a(jk.this.getContext());
              break;
            }
          }
        });
        this.U.setOnLongClickListener(this.u);
      }
      if ((!this.m.c()) || (i == 0)) {}
    }
    else
    {
      try
      {
        if (this.ac == null)
        {
          localObject1 = (ViewGroup)findViewById(2131755628);
          localObject3 = new GoogleMapOptions();
          localObject4 = new LatLng(this.a.B, this.a.C);
          localObject4 = new CameraPosition.a().a((LatLng)localObject4).a(15.0F).a();
          ((GoogleMapOptions)localObject3).a().e().b().b(false).a(false).d(false).c(false).c().a((CameraPosition)localObject4).d();
          com.google.android.gms.maps.e.a(getContext());
          this.ac = new c(getContext(), (GoogleMapOptions)localObject3);
          if (ae) {
            break label506;
          }
          this.ac.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              jk.a(jk.this).getViewTreeObserver().removeOnPreDrawListener(this);
              jk.a(jk.this).post(new Runnable()
              {
                public final void run()
                {
                  if (d.n())
                  {
                    jk.this.postDelayed(this, 1000L);
                    return;
                  }
                  try
                  {
                    jk.a(jk.this).a(null);
                    jk.a(jk.this).a();
                    jk.p();
                    return;
                  }
                  catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
                  {
                    for (;;)
                    {
                      Log.i(localIncompatibleClassChangeError);
                    }
                  }
                }
              });
              return true;
            }
          });
          label226:
          ((ViewGroup)localObject1).addView(this.ac, -1, -1);
        }
        this.ac.setVisibility(0);
        this.ac.a(new jl(this));
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
      {
        for (;;)
        {
          Object localObject1;
          label259:
          Log.i(localIncompatibleClassChangeError);
        }
      }
      localObject4 = this.a.b();
      if (this.R != null) {
        this.R.setVisibility(8);
      }
      if (TextUtils.isEmpty(this.a.y)) {
        break label1095;
      }
    }
    label355:
    label461:
    label506:
    label594:
    label656:
    label691:
    Object localObject2;
    label867:
    label874:
    label887:
    label906:
    label917:
    label1078:
    label1095:
    for (localObject1 = this.a.y.split("\n");; localObject2 = null)
    {
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        this.V.setVisibility(8);
        this.W.setVisibility(8);
        this.aa.setText(null);
        this.aa.setVisibility(8);
        if (this.ab != null) {
          this.ab.setVisibility(0);
        }
        if (this.Q != null) {
          this.Q.setVisibility(8);
        }
        if ((localObject4 == null) || (!((MediaData)localObject4).transferring)) {
          break label917;
        }
        if (!this.a.e.b) {
          break label906;
        }
        this.V.setVisibility(8);
        this.W.setVisibility(8);
        this.S.setVisibility(0);
        if (this.R != null) {
          this.R.setVisibility(0);
        }
        this.U.setOnClickListener(null);
        f();
      }
      for (;;)
      {
        localObject1 = new ag.a()
        {
          public final int a()
          {
            return (int)(252.0F * aoa.a().a);
          }
          
          public final void a(View paramAnonymousView)
          {
            jk.b(jk.this).setImageDrawable(null);
            jk.b(jk.this).setBackgroundColor(-7829368);
          }
          
          public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
          {
            if (paramAnonymousBitmap != null)
            {
              jk.b(jk.this).setImageBitmap(paramAnonymousBitmap);
              return;
            }
            jk.b(jk.this).setImageResource(2130840348);
          }
        };
        if (!this.m.c()) {
          break label1078;
        }
        this.ad.a(this.a, this.T, (ag.a)localObject1);
        return;
        i = 0;
        break;
        this.ac.a(null);
        this.ac.a();
        break label226;
        if (this.ac == null) {
          break label259;
        }
        this.ac.setVisibility(8);
        break label259;
        this.V.setVisibility(0);
        if (TextUtils.isEmpty(this.a.p)) {
          if ((localIncompatibleClassChangeError.length > 1) && (localIncompatibleClassChangeError[1].startsWith(localIncompatibleClassChangeError[0])))
          {
            localObject3 = localIncompatibleClassChangeError[1];
            localObject3 = "https://maps.google.com/maps?q=" + Uri.encode(((String)localObject3).replaceAll("\\s+", "+")) + "&sll=" + this.a.B + "," + this.a.C;
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localIncompatibleClassChangeError[0]);
            Context localContext = getContext();
            if (!this.a.e.b) {
              break label867;
            }
            i = 2131624044;
            i = b.c(localContext, i);
            localSpannableStringBuilder.setSpan(new ti(this.l, (String)localObject3, i), 0, localIncompatibleClassChangeError[0].length(), 18);
            this.V.setText(a(localSpannableStringBuilder), TextView.BufferType.SPANNABLE);
            this.W.setVisibility(0);
            if ((localIncompatibleClassChangeError.length <= 1) || (TextUtils.isEmpty(localIncompatibleClassChangeError[1]))) {
              break label874;
            }
            localObject2 = a(localIncompatibleClassChangeError[1]);
            this.W.setText((CharSequence)localObject2);
          }
        }
        for (;;)
        {
          localObject2 = new at()
          {
            public final void a(View paramAnonymousView)
            {
              Uri localUri = Uri.parse(localObject3);
              paramAnonymousView = localUri;
              if (localUri.getScheme() == null) {
                paramAnonymousView = Uri.parse("http://" + localObject3);
              }
              paramAnonymousView = new Intent("android.intent.action.VIEW", paramAnonymousView);
              try
              {
                jk.this.getContext().startActivity(paramAnonymousView);
                return;
              }
              catch (ActivityNotFoundException paramAnonymousView)
              {
                paramAnonymousView = jk.this.l;
                pv.a(u.a().getApplicationContext(), 2131296289, 0);
              }
            }
          };
          this.W.setOnClickListener((View.OnClickListener)localObject2);
          localObject2 = Uri.parse((String)localObject3).getHost();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!P.contains(localObject2))) {
            break label887;
          }
          this.aa.setText(null);
          this.aa.setVisibility(8);
          break;
          localObject3 = this.a.y;
          break label594;
          localObject3 = this.a.p;
          break label656;
          i = 2131624043;
          break label691;
          this.W.setText("");
        }
        this.aa.setText((CharSequence)localObject2);
        this.aa.setVisibility(0);
        break label355;
        this.S.setVisibility(0);
        break label461;
        if ((!this.a.e.b) || (localObject4 == null) || (((MediaData)localObject4).transferred))
        {
          if (this.S != null) {
            this.S.setVisibility(8);
          }
          if (m.d(this.a)) {
            f();
          } else {
            e();
          }
        }
        else
        {
          f();
          if (this.S != null) {
            this.S.setVisibility(8);
          }
          if (this.Q != null)
          {
            this.Q.setVisibility(0);
            this.Q.setText(2131297619);
            this.Q.setOnClickListener(new a((byte)0));
          }
          if (this.R != null) {
            this.R.setVisibility(0);
          }
          this.U.setOnClickListener(new a((byte)0));
        }
      }
      this.ad.b(this.a, this.T, (ag.a)localObject2);
      return;
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        q();
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final int getCenteredLayoutId()
  {
    return getIncomingLayoutId();
  }
  
  protected final int getIncomingLayoutId()
  {
    if (this.m.c()) {
      return 2130903160;
    }
    return 2130903159;
  }
  
  protected final int getOutgoingLayoutId()
  {
    if (this.m.c()) {
      return 2130903163;
    }
    return 2130903162;
  }
  
  public final void i()
  {
    q();
    super.i();
  }
  
  final class a
    extends at
  {
    private a() {}
    
    public final void a(View paramView)
    {
      jk.this.C.c(jk.this.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */