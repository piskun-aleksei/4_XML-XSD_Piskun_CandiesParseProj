package by.bsuir.webproj.enums;

import by.bsuir.webproj.factory.*;

/**
 * Created by Алексей on 10.04.2016.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOCALE {
        {
            this.command = new LocaleCommand();
        }
    },
    BACK {
        {
            this.command = new BackCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegistrationCommand();
        }
    },
    PARSE {
        {
            this.command = new ParseCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
