/*
 * This file is part of SpoutPluginAPI (http://www.spout.org/).
 *
 * SpoutPluginAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SpoutPluginAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.getspout.spoutapi.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Location;

public class PacketDownloadMusic implements SpoutPacket {
	int x, y, z;
	int volume, distance;
	boolean soundEffect, notify;
	String URL, plugin;
	public PacketDownloadMusic() {

	}

	public PacketDownloadMusic(String plugin, String URL, Location loc, int distance, int volume, boolean soundEffect, boolean notify) {
		this.plugin = plugin;
		this.URL = URL;
		this.volume = volume;
		this.soundEffect = soundEffect;
		this.notify = notify;
		if (loc != null) {
			x = loc.getBlockX();
			y = loc.getBlockY();
			z = loc.getBlockZ();
			this.distance = distance;
		} else {
			this.distance = -1;
		}
	}

	@Override
	public int getNumBytes() {
		return 22 + PacketUtil.getNumBytes(URL) + PacketUtil.getNumBytes(plugin);
	}

	@Override
	public void readData(DataInputStream input) throws IOException {
		URL = PacketUtil.readString(input, 255);
		plugin = PacketUtil.readString(input, 255);
		distance = input.readInt();
		x = input.readInt();
		y = input.readInt();
		z = input.readInt();
		volume = input.readInt();
		soundEffect = input.readBoolean();
		notify = input.readBoolean();
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException {
		PacketUtil.writeString(output, URL);
		PacketUtil.writeString(output, plugin);
		output.writeInt(distance);
		output.writeInt(x);
		output.writeInt(y);
		output.writeInt(z);
		output.writeInt(volume);
		output.writeBoolean(soundEffect);
		output.writeBoolean(notify);
	}

	@Override
	public void run(int PlayerId) {

	}

	@Override
	public void failure(int id) {

	}

	@Override
	public PacketType getPacketType() {
		return PacketType.PacketDownloadMusic;
	}

	@Override
	public int getVersion() {
		return 0;
	}
}
