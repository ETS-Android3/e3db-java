/*
 * TOZNY NON-COMMERCIAL LICENSE
 *
 * Tozny dual licenses this product. For commercial use, please contact
 * info@tozny.com. For non-commercial use, the contents of this file are
 * subject to the TOZNY NON-COMMERCIAL LICENSE (the "License") which
 * permits use of the software only by government agencies, schools,
 * universities, non-profit organizations or individuals on projects that
 * do not receive external funding other than government research grants
 * and contracts.  Any other use requires a commercial license. You may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at https://tozny.com/legal/non-commercial-license.
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations under
 * the License. Portions of the software are Copyright (c) TOZNY LLC, 2018.
 * All rights reserved.
 *
 */

package com.tozny.e3db;

import okio.ByteString;

import static com.tozny.e3db.Checks.checkNotEmpty;

class Base64 {
  public static String encodeURL(byte[] bytes) {
    checkNotEmpty(bytes, "bytes");
    String s = ByteString.of(bytes).base64Url();
    int paddingIdx = s.indexOf("=");
    if(paddingIdx > -1)
      return s.substring(0, paddingIdx);
    else
      return s;
  }

  public static byte[] decodeURL(String encoded) {
    checkNotEmpty(encoded, "encoded");
    final ByteString byteString = ByteString.decodeBase64(encoded);
    if(byteString == null)
      return null;
    else
      return byteString.toByteArray();
  }
}
