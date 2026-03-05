/* @author Developer
 * @version 4.0
 * 
 */

package com.seveneleven.utility;

public class DownloadToken {

    private long createdTime;
    private long expiryMillis;

    public DownloadToken() {

        createdTime = System.currentTimeMillis();

        expiryMillis = 60 * 1000; // 1 minute
    }

    public boolean isExpired() {

        long now = System.currentTimeMillis();

        return (now - createdTime) > expiryMillis;
    }
}