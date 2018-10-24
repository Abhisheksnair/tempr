package com.whatsapp.location;

import android.content.Context;
import android.graphics.Canvas;
import android.location.Location;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Projection;

public class GoogleMapView
  extends MapView
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private GestureDetector a;
  private a b;
  private GeoPoint c = new GeoPoint(0, 0);
  private int d = 0;
  private int e = 0;
  
  public GoogleMapView(Context paramContext)
  {
    super(paramContext, paramContext.getString(2131298255));
    a();
  }
  
  public GoogleMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GoogleMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new GestureDetector(this);
    this.a.setOnDoubleTapListener(this);
  }
  
  private static Location b(GeoPoint paramGeoPoint)
  {
    Location localLocation = new Location("");
    localLocation.setLatitude(paramGeoPoint.getLatitudeE6() / 1000000.0D);
    localLocation.setLongitude(paramGeoPoint.getLongitudeE6() / 1000000.0D);
    return localLocation;
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    try
    {
      getController().animateTo(paramGeoPoint);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        getController().setCenter(paramGeoPoint);
        return;
      }
      catch (Exception paramGeoPoint) {}
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.b != null)
    {
      paramCanvas = getMapCenter();
      int i = getLatitudeSpan();
      int j = getLongitudeSpan();
      if ((!this.c.equals(paramCanvas)) || (this.d != i) || (this.e != j))
      {
        this.c = paramCanvas;
        this.d = i;
        this.e = j;
        this.b.a(paramCanvas);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public Location getCenterLocation()
  {
    return b(getMapCenter());
  }
  
  public int getRadius()
  {
    Location localLocation1 = b(getMapCenter());
    Location localLocation2 = b(getProjection().fromPixels(getWidth() / 2, 0));
    Location localLocation3 = b(getProjection().fromPixels(0, getHeight() / 2));
    return (int)Math.min(localLocation1.distanceTo(localLocation2), localLocation1.distanceTo(localLocation3));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return getController().zoomInFixing((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setMapListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(GeoPoint paramGeoPoint);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/GoogleMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */