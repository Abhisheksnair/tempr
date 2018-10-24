package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.g;
import android.support.v4.content.b;
import android.widget.ImageView;
import com.whatsapp.data.ProfilePhotoChange;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.az;

public final class jp
  extends ip
{
  private ImageView Q = (ImageView)findViewById(2131755635);
  private ImageView R = (ImageView)findViewById(2131755637);
  private ImageView S = (ImageView)findViewById(2131755636);
  
  jp(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    this.S.setImageDrawable(new az(b.a(paramContext, 2130840135)));
    q();
  }
  
  private void q()
  {
    if ((this.a.e.b) && (this.a.d == 6) && (this.a.t == 6L) && ((this.a.N instanceof ProfilePhotoChange)))
    {
      Object localObject2 = (ProfilePhotoChange)this.a.N;
      if ((((ProfilePhotoChange)localObject2).newPhoto != null) && (((ProfilePhotoChange)localObject2).oldPhoto != null))
      {
        Object localObject1 = BitmapFactory.decodeByteArray(((ProfilePhotoChange)localObject2).newPhoto, 0, ((ProfilePhotoChange)localObject2).newPhoto.length);
        localObject2 = BitmapFactory.decodeByteArray(((ProfilePhotoChange)localObject2).oldPhoto, 0, ((ProfilePhotoChange)localObject2).oldPhoto.length);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject2 = d.a(getContext().getResources(), (Bitmap)localObject2);
          localObject1 = d.a(getContext().getResources(), (Bitmap)localObject1);
          ((g)localObject2).b();
          ((g)localObject1).b();
          this.Q.setImageDrawable((Drawable)localObject2);
          this.R.setImageDrawable((Drawable)localObject1);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Q.setVisibility(0);
        this.R.setVisibility(0);
        this.S.setVisibility(0);
        return;
      }
      this.Q.setVisibility(8);
      this.R.setVisibility(8);
      this.S.setVisibility(8);
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
  
  final int getBackgroundResource()
  {
    return 0;
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903164;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903164;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903164;
  }
  
  public final void i()
  {
    q();
    super.i();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */