package com.whatsapp.location;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Projection;

class e
  extends MyLocationOverlay
{
  private Point a = new Point();
  private Point b = new Point();
  private Paint c;
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private Handler g;
  
  e(Context paramContext, final MapView paramMapView)
  {
    super(paramContext, paramMapView);
    this.d = paramContext.getResources().getDrawable(2130840335);
    this.e = paramContext.getResources().getDrawable(2130840336);
    this.f = this.d;
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStrokeWidth(2.0F);
    this.g = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        if (e.a(e.this) == e.b(e.this)) {
          e.a(e.this, e.c(e.this));
        }
        for (;;)
        {
          paramMapView.invalidate(e.a(e.this).getBounds());
          sendEmptyMessageDelayed(0, 500L);
          return;
          e.a(e.this, e.b(e.this));
        }
      }
    };
    this.g.sendEmptyMessageDelayed(0, 500L);
  }
  
  public void disableMyLocation()
  {
    super.disableMyLocation();
    this.g.removeMessages(0);
  }
  
  protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation, GeoPoint paramGeoPoint, long paramLong)
  {
    int i = this.f.getIntrinsicWidth();
    int j = this.f.getIntrinsicHeight();
    paramMapView = paramMapView.getProjection();
    double d1 = paramLocation.getLatitude();
    double d2 = paramLocation.getLongitude();
    float f1 = paramLocation.getAccuracy();
    paramLocation = new float[1];
    Location.distanceBetween(d1, d2, d1, d2 + 1.0D, paramLocation);
    float f2 = paramLocation[0];
    paramMapView.toPixels(new GeoPoint((int)(d1 * 1000000.0D), (int)((d2 - f1 / f2) * 1000000.0D)), this.b);
    paramMapView.toPixels(paramGeoPoint, this.a);
    int k = this.a.x - this.b.x;
    this.c.setColor(-10066177);
    this.c.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(this.a.x, this.a.y, k, this.c);
    this.c.setColor(409364223);
    this.c.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.a.x, this.a.y, k, this.c);
    this.f.setBounds(this.a.x - i / 2, this.a.y - j / 2, this.a.x + i / 2, this.a.y + j / 2);
    this.f.draw(paramCanvas);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */