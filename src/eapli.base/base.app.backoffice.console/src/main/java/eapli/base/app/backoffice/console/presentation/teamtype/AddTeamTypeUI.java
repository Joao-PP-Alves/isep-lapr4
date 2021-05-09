/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation.teamtype;

import eapli.base.collaboratormanagement.domain.Collaborator;
import eapli.base.team.application.AddTeamController;
import eapli.base.teamtype.application.AddTeamTypeController;
import eapli.base.teamtype.domain.Color;
import eapli.base.teamtype.domain.TeamType;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Based on AddUserUI
 * Created by João Correia
 */
public class AddTeamTypeUI extends AbstractUI {

    private final AddTeamTypeController theController = new AddTeamTypeController();

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp
        final String teamTypeId = Console.readLine("Team Type ID");
        //final String color = Console.readLine("Team Type Color");
        final String description = Console.readLine("Description");

        final List<String> colors = new LinkedList<>();
        boolean show;
        do {
            show = showTeamColors(colors);
        } while (!show);

        try {
            this.theController.addTeamType(teamTypeId, colors, description);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("A TeamType already exists with specified ID.");
        }

        return false;
    }

    private boolean showTeamColors(final List<String> colors) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu colorsMenu = buildColorsMenu(colors);
        final MenuRenderer renderer = new VerticalMenuRenderer(colorsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildColorsMenu(final List<String> colors) {
        final Menu colorsMenu = new Menu();
        int counter = 0;
        colorsMenu.addItem(MenuItem.of(counter++, "No Color", Actions.SUCCESS));
        List<String> colorsList = theController.getTeamColors();
        for (String color : colorsList) {
            colorsMenu.addItem(MenuItem.of(counter++, color, () -> colors.add(color)));
        }
        return colorsMenu;
    }


    @Override
    public String headline() {
        return "Add Team Type";
    }
}
