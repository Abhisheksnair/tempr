package com.whatsapp.protocol;

import java.io.UnsupportedEncodingException;

public final class s
{
  public static byte a = 2;
  public static byte b = 1;
  public static String[] c = { null, null, null, "account", "ack", "action", "active", "add", "after", "all", "allow", "apple", "audio", "auth", "author", "available", "bad-protocol", "bad-request", "before", "bits", "body", "broadcast", "cancel", "category", "challenge", "chat", "clean", "code", "composing", "config", "contacts", "count", "create", "creation", "debug", "default", "delete", "delivery", "delta", "deny", "digest", "dirty", "duplicate", "elapsed", "enable", "encoding", "encrypt", "error", "event", "expiration", "expired", "fail", "failure", "false", "favorites", "feature", "features", "feature-not-implemented", "field", "file", "filehash", "first", "free", "from", "g.us", "gcm", "get", "google", "group", "groups", "groups_v2", "http://etherx.jabber.org/streams", "http://jabber.org/protocol/chatstates", "ib", "id", "image", "img", "index", "internal-server-error", "ip", "iq", "item-not-found", "item", "jabber:iq:last", "jabber:iq:privacy", "jabber:x:event", "jid", "kind", "last", "leave", "list", "max", "mechanism", "media", "message_acks", "message", "method", "microsoft", "mimetype", "missing", "modify", "msg", "mute", "name", "nokia", "none", "not-acceptable", "not-allowed", "not-authorized", "notification", "notify", "off", "offline", "order", "owner", "owning", "p_o", "p_t", "paid", "participant", "participants", "participating", "paused", "picture", "pin", "ping", "pkmsg", "platform", "port", "presence", "preview", "probe", "prop", "props", "qcount", "query", "raw", "read", "readreceipts", "reason", "receipt", "relay", "remote-server-timeout", "remove", "request", "required", "resource-constraint", "resource", "response", "result", "retry", "rim", "s_o", "s_t", "s.us", "s.whatsapp.net", "seconds", "server-error", "server", "service-unavailable", "set", "show", "silent", "size", "skmsg", "stat", "state", "status", "stream:error", "stream:features", "subject", "subscribe", "success", "sync", "t", "text", "timeout", "timestamp", "tizen", "to", "true", "type", "unavailable", "unsubscribe", "upgrade", "uri", "url", "urn:ietf:params:xml:ns:xmpp-sasl", "urn:ietf:params:xml:ns:xmpp-stanzas", "urn:ietf:params:xml:ns:xmpp-streams", "urn:xmpp:ping", "urn:xmpp:whatsapp:account", "urn:xmpp:whatsapp:dirty", "urn:xmpp:whatsapp:mms", "urn:xmpp:whatsapp:push", "urn:xmpp:whatsapp", "user", "user-not-found", "v", "value", "version", "voip", "w:g", "w:p:r", "w:p", "w:profile:picture", "w", "wait", "WAUTH-2", "xmlns:stream", "xmlns", "1", "chatstate", "crypto", "phash", "enc", "class", "off_cnt", "w:g2", "promote", "demote", "creator", "background", "backoff", "chunked", "context", "full", "in", "interactive", "out", "registration", "sid", "urn:xmpp:whatsapp:sync", "flt", "s16", "u8" };
  public static String[] d = { "adpcm", "amrnb", "amrwb", "mp3", "pcm", "qcelp", "wma", "h263", "h264", "jpeg", "mpeg4", "wmv", "audio/3gpp", "audio/aac", "audio/amr", "audio/mp4", "audio/mpeg", "audio/ogg", "audio/qcelp", "audio/wav", "audio/webm", "audio/x-caf", "audio/x-ms-wma", "image/gif", "image/jpeg", "image/png", "video/3gpp", "video/avi", "video/mp4", "video/mpeg", "video/quicktime", "video/x-flv", "video/x-ms-asf", "302", "400", "401", "402", "403", "404", "405", "406", "407", "409", "410", "500", "501", "503", "504", "abitrate", "acodec", "app_uptime", "asampfmt", "asampfreq", "clear", "conflict", "conn_no_nna", "cost", "currency", "duration", "extend", "fps", "g_notify", "g_sound", "gone", "google_play", "hash", "height", "invalid", "jid-malformed", "latitude", "lc", "lg", "live", "location", "log", "longitude", "max_groups", "max_participants", "max_subject", "mode", "napi_version", "normalize", "orighash", "origin", "passive", "password", "played", "policy-violation", "pop_mean_time", "pop_plus_minus", "price", "pricing", "redeem", "Replaced by new connection", "resume", "signature", "sound", "source", "system-shutdown", "username", "vbitrate", "vcard", "vcodec", "video", "width", "xml-not-well-formed", "checkmarks", "image_max_edge", "image_max_kbytes", "image_quality", "ka", "ka_grow", "ka_shrink", "newmedia", "library", "caption", "forward", "c0", "c1", "c2", "c3", "clock_skew", "cts", "k0", "k1", "login_rtt", "m_id", "nna_msg_rtt", "nna_no_off_count", "nna_offline_ratio", "nna_push_rtt", "no_nna_con_count", "off_msg_rtt", "on_msg_rtt", "stat_name", "sts", "suspect_conn", "lists", "self", "qr", "web", "w:b", "recipient", "w:stats", "forbidden", "max_list_recipients", "en-AU", "en-GB", "es-MX", "pt-PT", "zh-Hans", "zh-Hant", "relayelection", "relaylatency", "interruption", "Bell.caf", "Boing.caf", "Glass.caf", "Harp.caf", "TimePassing.caf", "Tri-tone.caf", "Xylophone.caf", "aurora.m4r", "bamboo.m4r", "chord.m4r", "circles.m4r", "complete.m4r", "hello.m4r", "input.m4r", "keys.m4r", "note.m4r", "popcorn.m4r", "pulse.m4r", "synth.m4r", "Apex.m4r", "Beacon.m4r", "Bulletin.m4r", "By The Seaside.m4r", "Chimes.m4r", "Circuit.m4r", "Constellation.m4r", "Cosmic.m4r", "Crystals.m4r", "Hillside.m4r", "Illuminate.m4r", "Night Owl.m4r", "Opening.m4r", "Playtime.m4r", "Presto.m4r", "Radar.m4r", "Radiate.m4r", "Ripples.m4r", "Sencha.m4r", "Signal.m4r", "Silk.m4r", "Slow Rise.m4r", "Stargaze.m4r", "Summit.m4r", "Twinkle.m4r", "Uplift.m4r", "Waves.m4r", "eligible", "planned", "current", "future", "disable", "expire", "start", "stop", "accuracy", "speed", "bearing", "recording", "key", "identity", "w:gp2", "admin", "locked", "unlocked", "new", "battery", "archive", "adm", "plaintext_size", "plaintext_disabled", "plaintext_reenable_threshold", "compressed_size", "delivered", "everyone", "transport", "mspes", "e2e_groups", "e2e_images", "encr_media", "encrypt_v2", "encrypt_image", "encrypt_sends_push", "force_long_connect", "audio_opus", "video_max_edge", "call-id", "call", "preaccept", "accept", "offer", "reject", "busy", "te", "terminate", "begin", "end", "opus", "rtt", "token", "priority", "p2p", "rate", "amr", "ptt", "srtp", "os", "browser", "encrypt_group_gen2", "encrypt_audio", "encrypt_blist", "encrypt_contact", "encrypt_location", "encrypt_url", "encrypt_video", "doc_types", "upload_oom_hprof_enabled", "tos", "client", "e2e_audio", "e2e_blists", "e2e_video", "document", "contact", "file_max_size", "small_call_btn", "enable_mp4_operations_mux", "android_vacuuming_enabled", "android_vacuum_experiment_enabled", "aec", "agc", "options", "encode", "bwe", "rc", "ns", "ec_threshold", "ec_off_threshold", "algorithm", "targetlevel", "compressiongain", "limiterenable", "cbr", "complexity", "minfpp", "maxrtt", "low_data_usage_bitrate", "usync", "refresh", "media_max_autodownload" };
  public static String[] e = { null, null, null, "200", "400", "404", "500", "501", "502", "action", "add", "after", "archive", "author", "available", "battery", "before", "body", "broadcast", "chat", "clear", "code", "composing", "contacts", "count", "create", "debug", "delete", "demote", "duplicate", "encoding", "error", "false", "filehash", "from", "g.us", "group", "groups_v2", "height", "id", "image", "in", "index", "invis", "item", "jid", "kind", "last", "leave", "live", "log", "media", "message", "mimetype", "missing", "modify", "name", "notification", "notify", "out", "owner", "participant", "paused", "picture", "played", "presence", "preview", "promote", "query", "raw", "read", "receipt", "received", "recipient", "recording", "relay", "remove", "response", "resume", "retry", "s.whatsapp.net", "seconds", "set", "size", "status", "subject", "subscribe", "t", "text", "to", "true", "type", "unarchive", "unavailable", "url", "user", "value", "web", "width", "mute", "read_only", "admin", "creator", "short", "update", "powersave", "checksum", "epoch", "block", "previous", "409", "replaced", "reason", "spam", "modify_tag", "message_info", "delivery", "emoji", "title", "description", "canonical-url", "matched-text", "star", "unstar", "media_key", "filename", "identity", "unread", "page", "page_count", "search", "media_message", "security", "call_log", "profile", "ciphertext", "invite", "gif", "vcard", "frequent", "privacy", "blacklist", "whitelist", "verify" };
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = -1;
    int k = -1;
    int m;
    int n;
    for (;;)
    {
      m = j;
      n = k;
      if (i >= j.c.length) {
        break;
      }
      if (j.c[i] == paramInt1) {
        k = i;
      }
      if (j.c[i] == paramInt2) {
        j = i;
      }
      if (k != -1)
      {
        m = j;
        n = k;
        if (j != -1) {
          break;
        }
      }
      i += 1;
    }
    if (n < m) {
      return -1;
    }
    if (n > m) {
      return 1;
    }
    return 0;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte) {}
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("UTF-8");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString) {}
    }
    return null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */