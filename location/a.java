package com.whatsapp.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Projection;

public class a
  extends MyLocationOverlay
{
  private final Point a = new Point();
  private final BitmapDrawable b;
  
  public a(Context paramContext, MapView paramMapView, BitmapDrawable paramBitmapDrawable)
  {
    super(paramContext, paramMapView);
    this.b = paramBitmapDrawable;
  }
  
  protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation, GeoPoint paramGeoPoint, long paramLong)
  {
    int i = this.b.getIntrinsicWidth();
    int j = this.b.getIntrinsicHeight();
    paramMapView.getProjection().toPixels(paramGeoPoint, this.a);
    paramMapView = this.b;
    int k = this.a.x;
    int m = i / 2;
    int n = this.a.y;
    int i1 = this.a.x;
    paramMapView.setBounds(k - m, n - j, i / 2 + i1, this.a.y);
    this.b.draw(paramCanvas);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */