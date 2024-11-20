import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.TlsClientProtocol;

@ObfuscatedName("al")
@Implements("SecureRandomSSLSocket")
class SecureRandomSSLSocket extends SSLSocket {
	@ObfuscatedName("ab")
	Certificate[] field57;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	final SecureRandomSSLSocketFactory this$0;
	// $FF: synthetic field
	final TlsClientProtocol val$tlsClientProtocol;
	// $FF: synthetic field
	final String val$host;

	@ObfuscatedSignature(
		descriptor = "(Laz;Lorg/bouncycastle/crypto/tls/TlsClientProtocol;Ljava/lang/String;)V"
	)
	SecureRandomSSLSocket(SecureRandomSSLSocketFactory var1, TlsClientProtocol var2, String var3) {
		this.this$0 = var1;
		this.val$tlsClientProtocol = var2;
		this.val$host = var3;
	}

	public InputStream getInputStream() throws IOException {
		return this.val$tlsClientProtocol.getInputStream();
	}

	public OutputStream getOutputStream() throws IOException {
		return this.val$tlsClientProtocol.getOutputStream();
	}

	public void addHandshakeCompletedListener(HandshakeCompletedListener var1) {
	}

	public String[] getEnabledCipherSuites() {
		return null;
	}

	public String[] getEnabledProtocols() {
		return null;
	}

	public String[] getSupportedCipherSuites() {
		return null;
	}

	public SSLSession getSession() {
		return new class17(this);
	}

	public boolean getUseClientMode() {
		return false;
	}

	public boolean getWantClientAuth() {
		return false;
	}

	public void setEnableSessionCreation(boolean var1) {
	}

	public void setEnabledProtocols(String[] var1) {
	}

	public void setNeedClientAuth(boolean var1) {
	}

	public void setWantClientAuth(boolean var1) {
	}

	public void startHandshake() throws IOException {
		this.val$tlsClientProtocol.connect(new class13(this));
	}

	public boolean getEnableSessionCreation() {
		return false;
	}

	public synchronized void close() throws IOException {
		this.val$tlsClientProtocol.close();
	}

	public void setEnabledCipherSuites(String[] var1) {
	}

	public String[] getSupportedProtocols() {
		return null;
	}

	public void removeHandshakeCompletedListener(HandshakeCompletedListener var1) {
	}

	public boolean getNeedClientAuth() {
		return false;
	}

	public void setUseClientMode(boolean var1) {
	}
}
