package com.whatsapp;

import a.a.a.a.a.a;
import a.a.a.a.a.a.b;
import a.a.a.a.a.a.c;
import a.a.a.a.a.a.e;
import a.a.a.a.a.d;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.support.v4.app.m;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.whatsapp.data.cm;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.ba;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class ik
  extends hy
{
  a O;
  ArrayList<String> P;
  private final TextView Q;
  private final ImageView R;
  private final TextView S;
  private final TextView T;
  private ArrayList<String> U;
  private int V;
  private final com.whatsapp.util.a.c W = com.whatsapp.util.a.c.a();
  private final od aa = od.a();
  private final cm ab = cm.a();
  private final ani ac = ani.a();
  private final ba ad = ba.a();
  private final di.e ae;
  
  ik(Context paramContext, j paramj, di.e parame)
  {
    super(paramContext, paramj);
    this.ae = parame;
    this.Q = ((TextView)findViewById(2131755594));
    this.R = ((ImageView)findViewById(2131755467));
    this.S = ((TextView)findViewById(2131755596));
    this.T = ((TextView)findViewById(2131755598));
    paramContext = (LinearLayout)findViewById(2131755593);
    paramContext.setOnClickListener(new e((byte)0));
    paramContext.setOnLongClickListener(this.u);
    e();
    p();
  }
  
  private static boolean c(a parama)
  {
    if (parama == null) {
      return false;
    }
    List localList = parama.h;
    if ((localList != null) && (localList.size() > 0)) {
      return true;
    }
    parama = parama.i;
    if (parama != null)
    {
      parama = parama.iterator();
      while (parama.hasNext()) {
        if (((a.b)parama.next()).a == ContactsContract.CommonDataKinds.Email.class) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void p()
  {
    int k = 1;
    Object localObject1 = com.whatsapp.emoji.c.a(this.a.y, getContext(), this.Q.getPaint());
    this.Q.setText(a((CharSequence)localObject1));
    this.O = null;
    try
    {
      this.O = a.a(u.a(), this.F, this.a.e());
      localObject1 = cs.b(2130837625);
      this.R.setImageBitmap((Bitmap)localObject1);
      if (this.O != null) {
        this.ae.a(this.O, this.R);
      }
      this.V = 0;
      this.P = new ArrayList();
      this.U = new ArrayList();
      if ((this.O != null) && (this.O.h != null))
      {
        localObject1 = this.O.h.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label341;
          }
          localObject3 = (a.e)((Iterator)localObject1).next();
          this.U.add(((a.e)localObject3).b);
          if (((a.e)localObject3).e == null) {
            break;
          }
          localObject3 = ((a.e)localObject3).e + "@s.whatsapp.net";
          this.P.add(localObject3);
          this.V += 1;
        }
      }
    }
    catch (d locald)
    {
      for (;;)
      {
        Log.c("remote_resource: " + this.a.f, locald);
      }
    }
    catch (Exception localException)
    {
      Object localObject3;
      for (;;)
      {
        Log.d("conversationrowcontact/fillview/unexpected error parsing vcard", localException);
        this.W.a("ConversationRowContact unexpected vcard parsing exception: " + localException.getMessage(), false, null, -1);
        continue;
        this.P.add(null);
      }
      if (!this.a.e.b)
      {
        Object localObject2;
        int j;
        if (qz.e(this.a.e.a))
        {
          localObject2 = this.F.d(this.a.f);
          if (this.ab.a(this.a.e.a) != 1)
          {
            i = 1;
            if (this.J.a(this.a.e.a)) {
              break label617;
            }
            j = 1;
            i &= j;
            if (((cs)localObject2).d != null) {
              break label646;
            }
            j = 1;
            if (this.ab.a(((cs)localObject2).t) == 1) {
              break label651;
            }
            i = i & j & k;
            localObject2 = findViewById(2131755595);
            localObject3 = findViewById(2131755597);
            if (i != 0) {
              break label766;
            }
            if (this.V <= 0) {
              break label656;
            }
            this.S.setVisibility(0);
            this.S.setText(2131297661);
            this.S.setOnClickListener(new d((byte)0));
            if (!this.a.e.b) {
              break label715;
            }
            ((View)localObject3).setVisibility(8);
            this.T.setVisibility(8);
            if ((this.S.getVisibility() != 0) && (this.T.getVisibility() != 0)) {
              break label748;
            }
            ((View)localObject2).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((this.S.getVisibility() != 0) || (this.T.getVisibility() != 0)) {
            break label758;
          }
          ((View)localObject3).setVisibility(0);
          return;
          i = 0;
          break;
          j = 0;
          break label431;
          localObject2 = this.F.d(this.a.e.a);
          i = 1;
          break label435;
          j = 0;
          break label445;
          k = 0;
          break label461;
          if (c(this.O))
          {
            this.S.setVisibility(0);
            this.S.setText(2131297067);
            this.S.setOnClickListener(new b((byte)0));
            break label530;
          }
          this.S.setVisibility(8);
          break label530;
          ((View)localObject3).setVisibility(0);
          this.T.setVisibility(0);
          this.T.setOnClickListener(new a((byte)0));
          break label559;
          ((View)localObject2).setVisibility(8);
        }
        ((View)localObject3).setVisibility(8);
        return;
        this.S.setVisibility(8);
        this.T.setVisibility(8);
        ((View)localObject2).setVisibility(8);
        ((View)localObject3).setVisibility(8);
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        label341:
        label431:
        label435:
        label445:
        label461:
        label530:
        label559:
        label617:
        label646:
        label651:
        label656:
        label715:
        label748:
        label758:
        label766:
        continue;
        int i = 0;
      }
    }
  }
  
  @TargetApi(11)
  protected final void a(Bitmap paramBitmap)
  {
    Context localContext = getContext();
    if ((localContext instanceof Conversation)) {
      ((Conversation)localContext).a(this.O, paramBitmap);
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        p();
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
    return 2130903140;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903140;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903141;
  }
  
  public final void i()
  {
    super.i();
    p();
  }
  
  public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (Build.VERSION.SDK_INT >= 14) {
      paramAccessibilityNodeInfo.setText(this.Q.getText());
    }
  }
  
  public final void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (Build.VERSION.SDK_INT >= 14) {
      paramAccessibilityEvent.getText().add(this.Q.getText());
    }
  }
  
  final class a
    extends at
  {
    private a() {}
    
    public final void a(View paramView)
    {
      if (ik.d(ik.this) == null)
      {
        Log.w("conversationrowcontact/addcontactonclicklistener/contact is null");
        paramView = ik.this.l;
        pv.a(ik.this.getContext(), 2131296747, 0);
        return;
      }
      Object localObject = null;
      paramView = (View)localObject;
      if (ik.d(ik.this).f != null)
      {
        paramView = (View)localObject;
        if (ik.d(ik.this).f.length > 0) {
          paramView = BitmapFactory.decodeByteArray(ik.d(ik.this).f, 0, ik.d(ik.this).f.length);
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        ik.c(ik.this).a(ik.d(ik.this), paramView, ik.e(ik.this), ik.b(ik.this), (nh)ik.this.getContext());
        return;
      }
      ik.this.a(paramView);
    }
  }
  
  final class b
    extends at
  {
    private b() {}
    
    public final void a(View paramView)
    {
      if (!ik.a(ik.d(ik.this))) {
        return;
      }
      paramView = ik.b(ik.d(ik.this));
      if ((paramView.isEmpty()) && (ik.e(ik.this) != null) && (ik.e(ik.this).size() == 1))
      {
        b((String)ik.e(ik.this).get(0));
        return;
      }
      if (((ik.e(ik.this) == null) || (ik.e(ik.this).isEmpty())) && (paramView.size() == 1))
      {
        a((String)paramView.get(0));
        return;
      }
      ArrayList localArrayList = new ArrayList(ik.e(ik.this).size() + paramView.size());
      localArrayList.addAll(ik.e(ik.this));
      localArrayList.addAll(paramView);
      if (TextUtils.isEmpty(ik.d(ik.this).c.a)) {}
      for (paramView = ik.this.getContext().getString(2131297068);; paramView = ik.this.getContext().getString(2131297074, new Object[] { ik.d(ik.this).c.a }))
      {
        new b.a(ik.this.getContext()).a(paramView).a((CharSequence[])localArrayList.toArray(new String[localArrayList.size()]), il.a(this, localArrayList)).a().show();
        return;
      }
    }
    
    final void a(String paramString)
    {
      ik.f(ik.this).a(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.EMAIL", new String[] { paramString }).putExtra("android.intent.extra.SUBJECT", ik.this.getContext().getString(2131297980)).putExtra("android.intent.extra.TEXT", ik.this.getContext().getString(2131297979, new Object[] { "https://www.whatsapp.com/download/" }) + "\n\n"), ik.this.getContext(), null, ik.this.getContext().getString(2131297076));
    }
    
    final void b(String paramString)
    {
      ik.g(ik.this);
      ani.a((Activity)ik.this.getContext(), Uri.parse("sms:" + paramString), ik.this.getContext().getString(2131297981, new Object[] { "https://whatsapp.com/dl/" }));
    }
  }
  
  public static final class c
    extends m
  {
    final ba aa = ba.a();
    
    public static c a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
    {
      c localc = new c();
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("jids", paramArrayList1);
      localBundle.putStringArrayList("phones", paramArrayList2);
      localBundle.putStringArrayList("labels", paramArrayList3);
      localc.f(localBundle);
      return localc;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      ArrayList localArrayList2 = i().getStringArrayList("jids");
      ArrayList localArrayList3 = i().getStringArrayList("phones");
      ArrayList localArrayList4 = i().getStringArrayList("labels");
      ArrayList localArrayList1 = new ArrayList();
      if ((localArrayList2 != null) && (localArrayList4 != null) && (localArrayList3 != null))
      {
        int i = 0;
        if (i < localArrayList2.size())
        {
          StringBuilder localStringBuilder;
          if (localArrayList2.get(i) != null)
          {
            localStringBuilder = new StringBuilder().append(m().getString(2131297166, new Object[] { localArrayList3.get(i) }));
            if (!TextUtils.isEmpty((CharSequence)localArrayList4.get(i))) {
              break label167;
            }
          }
          label167:
          for (paramBundle = "";; paramBundle = " (" + (String)localArrayList4.get(i) + ")")
          {
            localArrayList1.add(new hy.b(paramBundle, (String)localArrayList2.get(i)));
            i += 1;
            break;
          }
        }
      }
      paramBundle = new b.a(k());
      paramBundle.a(new ArrayAdapter(k(), 2130903354, localArrayList1), im.a(this, localArrayList1));
      return paramBundle.a();
    }
  }
  
  final class d
    extends at
  {
    private d() {}
    
    public final void a(View paramView)
    {
      if (ik.a(ik.this) == 1)
      {
        paramView = ik.b(ik.this).iterator();
        while (paramView.hasNext())
        {
          localObject = (String)paramView.next();
          if (localObject != null) {
            ik.c(ik.this).a(ik.this.getContext(), (String)localObject);
          }
        }
      }
      do
      {
        return;
        paramView = ik.this;
        localObject = paramView.getContext();
      } while (!(localObject instanceof android.support.v7.app.c));
      Object localObject = (android.support.v7.app.c)localObject;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      if (i < paramView.O.h.size())
      {
        if (paramView.P.get(i) != null)
        {
          localArrayList1.add(((a.e)paramView.O.h.get(i)).b);
          localArrayList2.add(((a.e)paramView.O.h.get(i)).c);
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList1.add(null);
          localArrayList2.add(null);
        }
      }
      ik.c.a(paramView.P, localArrayList1, localArrayList2).a(((android.support.v7.app.c)localObject).j_(), null);
    }
  }
  
  final class e
    extends at
  {
    private e() {}
    
    public final void a(View paramView)
    {
      paramView = ik.this.a.e();
      if (!TextUtils.isEmpty(paramView))
      {
        Intent localIntent = new Intent(ik.this.getContext(), ViewSharedContactArrayActivity.class);
        localIntent.putExtra("edit_mode", false);
        localIntent.putExtra("vcard", paramView);
        ik.this.getContext().startActivity(localIntent);
        return;
      }
      Log.w("conversationrowcontact/onclicklistener/vcard is empty");
      paramView = ik.this.l;
      pv.a(ik.this.getContext(), 2131296747, 0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */