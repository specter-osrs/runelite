import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("Texture")
public class Texture extends Node {
	@ObfuscatedName("aa")
	@Export("Texture_animatedPixels")
	static int[] Texture_animatedPixels;
	@ObfuscatedName("ad")
	@Export("averageRGB")
	int averageRGB;
	@ObfuscatedName("an")
	boolean field1907;
	@ObfuscatedName("ae")
	@Export("fileIds")
	int[] fileIds;
	@ObfuscatedName("ax")
	int[] field1909;
	@ObfuscatedName("at")
	int[] field1905;
	@ObfuscatedName("ac")
	int[] field1911;
	@ObfuscatedName("au")
	@Export("animationDirection")
	int animationDirection;
	@ObfuscatedName("as")
	@Export("animationSpeed")
	int animationSpeed;
	@ObfuscatedName("aq")
	@Export("pixels")
	int[] pixels;
	@ObfuscatedName("af")
	@Export("isLoaded")
	boolean isLoaded;

	@ObfuscatedSignature(
		descriptor = "(Lvy;)V"
	)
	Texture(Buffer var1) {
		this.isLoaded = false;
		this.averageRGB = var1.readUnsignedShort();
		this.field1907 = var1.readUnsignedByte() == 1;
		int var2 = var1.readUnsignedByte();
		if (var2 >= 1 && var2 <= 4) {
			this.fileIds = new int[var2];

			int var3;
			for (var3 = 0; var3 < var2; ++var3) {
				this.fileIds[var3] = var1.readUnsignedShort();
			}

			if (var2 > 1) {
				this.field1909 = new int[var2 - 1];

				for (var3 = 0; var3 < var2 - 1; ++var3) {
					this.field1909[var3] = var1.readUnsignedByte();
				}
			}

			if (var2 > 1) {
				this.field1905 = new int[var2 - 1];

				for (var3 = 0; var3 < var2 - 1; ++var3) {
					this.field1905[var3] = var1.readUnsignedByte();
				}
			}

			this.field1911 = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.field1911[var3] = var1.readInt();
			}

			this.animationDirection = var1.readUnsignedByte();
			this.animationSpeed = var1.readUnsignedByte();
			this.pixels = null;
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(DILpq;)Z"
	)
	@Export("load")
	boolean load(double var1, int var3, AbstractArchive var4) {
		int var5;
		for (var5 = 0; var5 < this.fileIds.length; ++var5) {
			if (var4.getFileFlat(this.fileIds[var5]) == null) {
				return false;
			}
		}

		var5 = var3 * var3;
		this.pixels = new int[var5];

		for (int var6 = 0; var6 < this.fileIds.length; ++var6) {
			int var8 = this.fileIds[var6];
			IndexedSprite var7;
			if (!WorldMapEvent.method6538(var4, var8)) {
				var7 = null;
			} else {
				IndexedSprite var10 = new IndexedSprite();
				var10.width = SpriteBufferProperties.SpriteBuffer_spriteWidth;
				var10.height = class174.SpriteBuffer_spriteHeight;
				var10.xOffset = class241.SpriteBuffer_xOffsets[0];
				var10.yOffset = SpriteBufferProperties.SpriteBuffer_yOffsets[0];
				var10.subWidth = SpriteBufferProperties.SpriteBuffer_spriteWidths[0];
				var10.subHeight = class403.SpriteBuffer_spriteHeights[0];
				var10.palette = KeyHandler.SpriteBuffer_spritePalette;
				var10.pixels = class240.SpriteBuffer_pixels[0];
				class241.SpriteBuffer_xOffsets = null;
				SpriteBufferProperties.SpriteBuffer_yOffsets = null;
				SpriteBufferProperties.SpriteBuffer_spriteWidths = null;
				class403.SpriteBuffer_spriteHeights = null;
				KeyHandler.SpriteBuffer_spritePalette = null;
				class240.SpriteBuffer_pixels = null;
				var7 = var10;
			}

			var7.normalize();
			byte[] var17 = var7.pixels;
			int[] var11 = var7.palette;
			int var12 = this.field1911[var6];
			if ((var12 & -16777216) == 16777216) {
			}

			if ((var12 & -16777216) == 33554432) {
			}

			int var13;
			int var14;
			int var15;
			int var16;
			if ((var12 & -16777216) == 50331648) {
				var13 = var12 & 16711935;
				var14 = var12 >> 8 & 255;

				for (var15 = 0; var15 < var11.length; ++var15) {
					var16 = var11[var15];
					if (var16 >> 8 == (var16 & 65535)) {
						var16 &= 255;
						var11[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & 65280;
					}
				}
			}

			for (var13 = 0; var13 < var11.length; ++var13) {
				var11[var13] = Rasterizer3D.Rasterizer3D_brighten(var11[var13], var1);
			}

			if (var6 == 0) {
				var13 = 0;
			} else {
				var13 = this.field1909[var6 - 1];
			}

			if (var13 == 0) {
				if (var3 == var7.subWidth) {
					for (var14 = 0; var14 < var5; ++var14) {
						this.pixels[var14] = var11[var17[var14] & 255];
					}
				} else if (var7.subWidth == 64 && var3 == 128) {
					var14 = 0;

					for (var15 = 0; var15 < var3; ++var15) {
						for (var16 = 0; var16 < var3; ++var16) {
							this.pixels[var14++] = var11[var17[(var15 >> 1 << 6) + (var16 >> 1)] & 255];
						}
					}
				} else {
					if (var7.subWidth != 128 || var3 != 64) {
						throw new RuntimeException();
					}

					var14 = 0;

					for (var15 = 0; var15 < var3; ++var15) {
						for (var16 = 0; var16 < var3; ++var16) {
							this.pixels[var14++] = var11[var17[(var16 << 1) + (var15 << 1 << 7)] & 255];
						}
					}
				}
			}

			if (var13 == 1) {
			}

			if (var13 == 2) {
			}

			if (var13 == 3) {
			}
		}

		return true;
	}

	@ObfuscatedName("ah")
	@Export("reset")
	void reset() {
		this.pixels = null;
	}

	@ObfuscatedName("az")
	@Export("animate")
	void animate(int var1) {
		if (this.pixels != null) {
			short var2;
			int var3;
			int var4;
			int var5;
			int var6;
			int var7;
			int[] var10;
			if (this.animationDirection == 1 || this.animationDirection == 3) {
				if (Texture_animatedPixels == null || Texture_animatedPixels.length < this.pixels.length) {
					Texture_animatedPixels = new int[this.pixels.length];
				}

				if (this.pixels.length == 4096) {
					var2 = 64;
				} else {
					var2 = 128;
				}

				var3 = this.pixels.length;
				var4 = var2 * this.animationSpeed * var1;
				var5 = var3 - 1;
				if (this.animationDirection == 1) {
					var4 = -var4;
				}

				for (var6 = 0; var6 < var3; ++var6) {
					var7 = var6 + var4 & var5;
					Texture_animatedPixels[var6] = this.pixels[var7];
				}

				var10 = this.pixels;
				this.pixels = Texture_animatedPixels;
				Texture_animatedPixels = var10;
			}

			if (this.animationDirection == 2 || this.animationDirection == 4) {
				if (Texture_animatedPixels == null || Texture_animatedPixels.length < this.pixels.length) {
					Texture_animatedPixels = new int[this.pixels.length];
				}

				if (this.pixels.length == 4096) {
					var2 = 64;
				} else {
					var2 = 128;
				}

				var3 = this.pixels.length;
				var4 = this.animationSpeed * var1;
				var5 = var2 - 1;
				if (this.animationDirection == 2) {
					var4 = -var4;
				}

				for (var6 = 0; var6 < var3; var6 += var2) {
					for (var7 = 0; var7 < var2; ++var7) {
						int var8 = var6 + var7;
						int var9 = var6 + (var7 + var4 & var5);
						Texture_animatedPixels[var8] = this.pixels[var9];
					}
				}

				var10 = this.pixels;
				this.pixels = Texture_animatedPixels;
				Texture_animatedPixels = var10;
			}

		}
	}
}
