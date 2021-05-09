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
package eapli.base.app.backoffice.console.presentation.team;

import eapli.base.team.application.AddTeamController;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.HashSet;
import java.util.Set;

/**
 * UI for adding a user to the application.
 *
 * Created by nuno on 22/03/16.
 */
public class AddTeamUI extends AbstractUI {

    private final AddTeamController theController = new AddTeamController();

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp
        final String designation = Console.readLine("Designation");
        final String description = Console.readLine("Description");


        final Set<TeamType> teamTypes = new HashSet<>();
        boolean show;
        do {
            show = showTeamTypes(teamTypes);
        } while (!show);

        try {
            this.theController.addTeam(designation, description, teamTypes);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("A Team already exists with specified designation.");
        }

        return false;
    }

    private boolean showTeamTypes(final Set<TeamType> teamTypes) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu teamTypesMenu = buidlTeamTypesMenu(teamTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(teamTypesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buidlTeamTypesMenu(final Set<TeamType> teamTypes) {
        final Menu teamTypesMenu = new Menu();
        int counter = 0;
        teamTypesMenu.addItem(MenuItem.of(counter++, "No Role", Actions.SUCCESS));
        for (final TeamType teamType : theController.getTeamTypes()) {
            teamTypesMenu.addItem(MenuItem.of(counter++, teamType.toString(), () -> teamTypes.add(teamType)));
        }
        return teamTypesMenu;
    }

    @Override
    public String headline() {
        return "Add User";
    }
}
