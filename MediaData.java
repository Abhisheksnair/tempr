package com.whatsapp;

import java.io.File;
import java.io.Serializable;

public class MediaData
  implements Serializable
{
  public static final int GIPHY = 1;
  public static final int NONE = 0;
  public static int SUSPICIOUS_CONTENT_NO = 0;
  public static int SUSPICIOUS_CONTENT_YES = 1;
  public static int SUSPICIOUS_CONTENT_YES_IGNORE = 2;
  public static int SUSPICIOUS_CONTENT_YES_KEEP = 3;
  public static final int TENOR = 2;
  private static final long serialVersionUID = -3211751283609594L;
  public boolean autodownloadRetryEnabled;
  public long cachedDownloadedBytes;
  public byte[] cipherKey;
  public transient boolean dedupeDownload;
  public String doodleId;
  public transient vk downloader;
  public int faceX;
  public int faceY;
  public int failErrorCode;
  public File file;
  public long fileSize;
  public transient boolean forward;
  public int gifAttribution;
  public boolean hasStreamingSidecar;
  public int height;
  public byte[] hmacKey;
  public byte[] iv;
  public byte[] mediaKey;
  public transient boolean prefetching = false;
  public long progress;
  public byte[] refKey;
  public boolean showDownloadedBytes;
  public transient boolean streamViewable;
  public int suspiciousContent;
  public float thumbnailHeightWidthRatio;
  public boolean transcoded;
  public transient xf transcoder;
  public boolean transferred = false;
  public transient boolean transferring = false;
  public long trimFrom;
  public long trimTo;
  public boolean uploadRetry;
  public String uploadUrl;
  public transient xg uploader;
  public int width;
  
  public MediaData() {}
  
  public MediaData(MediaData paramMediaData)
  {
    this.transferred = paramMediaData.transferred;
    this.file = paramMediaData.file;
    this.fileSize = paramMediaData.fileSize;
    this.suspiciousContent = paramMediaData.suspiciousContent;
    this.faceX = paramMediaData.faceX;
    this.faceY = paramMediaData.faceY;
    this.mediaKey = paramMediaData.mediaKey;
    this.refKey = paramMediaData.refKey;
    this.cipherKey = paramMediaData.cipherKey;
    this.hmacKey = paramMediaData.hmacKey;
    this.iv = paramMediaData.iv;
    this.failErrorCode = paramMediaData.failErrorCode;
    this.width = paramMediaData.width;
    this.height = paramMediaData.height;
    this.doodleId = paramMediaData.doodleId;
    this.gifAttribution = paramMediaData.gifAttribution;
    this.thumbnailHeightWidthRatio = paramMediaData.thumbnailHeightWidthRatio;
    this.uploadRetry = paramMediaData.uploadRetry;
  }
  
  public static int getStatsGifProvider(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unexpected provider type " + paramInt);
    case 1: 
      return 0;
    }
    return 1;
  }
  
  public static int toGifAttribution(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public MediaData createSerializableCopy()
  {
    MediaData localMediaData = new MediaData();
    localMediaData.transferred = this.transferred;
    localMediaData.progress = this.progress;
    localMediaData.streamViewable = this.streamViewable;
    localMediaData.file = this.file;
    localMediaData.fileSize = this.fileSize;
    localMediaData.autodownloadRetryEnabled = this.autodownloadRetryEnabled;
    localMediaData.transcoded = this.transcoded;
    localMediaData.suspiciousContent = this.suspiciousContent;
    localMediaData.trimFrom = this.trimFrom;
    localMediaData.trimTo = this.trimTo;
    localMediaData.faceX = this.faceX;
    localMediaData.faceY = this.faceY;
    localMediaData.mediaKey = this.mediaKey;
    localMediaData.refKey = this.refKey;
    localMediaData.cipherKey = this.cipherKey;
    localMediaData.hmacKey = this.hmacKey;
    localMediaData.iv = this.iv;
    localMediaData.uploadUrl = this.uploadUrl;
    localMediaData.failErrorCode = this.failErrorCode;
    localMediaData.width = this.width;
    localMediaData.height = this.height;
    localMediaData.doodleId = this.doodleId;
    localMediaData.gifAttribution = this.gifAttribution;
    localMediaData.thumbnailHeightWidthRatio = this.thumbnailHeightWidthRatio;
    localMediaData.uploadRetry = this.uploadRetry;
    return localMediaData;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */