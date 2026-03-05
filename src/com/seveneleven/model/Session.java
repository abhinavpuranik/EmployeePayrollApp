
/* @author Developer
 * @version 2.0
 * Session managing after login
 */
package com.seveneleven.model;

public class Session {

    private String username;
    private long loginTime;
    private long timeoutMillis;

    public Session(String username) {
        this.username = username;
        this.loginTime = System.currentTimeMillis();
        this.timeoutMillis = 60000; // 1 minute session
    }

    public boolean isExpired() {

        long currentTime = System.currentTimeMillis();

        return (currentTime - loginTime) > timeoutMillis;
    }

    public String toString() {
        return "Session active for user: " + username;
    }
}