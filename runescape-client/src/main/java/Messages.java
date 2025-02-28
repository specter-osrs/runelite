import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("ay")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lue;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lpz;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1013388835
	)
	@Export("Messages_count")
	static int Messages_count;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)[Loe;",
		garbageValue = "-2"
	)
	static GameBuild[] method3241() {
		return new GameBuild[]{GameBuild.WIP, GameBuild.RC, GameBuild.BUILDLIVE, GameBuild.LIVE};
	}
}
