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
package org.getspout.spoutapi.gui;

import java.util.List;

public interface ComboBox extends Button {
	public ComboBox setItems(List<String> items);
	public List<String> getItems();
	public ComboBox openList();
	public ComboBox closeList();
	public String getSelectedItem();
	public int getSelectedRow();
	public ComboBox setSelection(int row);
	public void onSelectionChanged(int i, String text);
	public boolean isOpen();
}