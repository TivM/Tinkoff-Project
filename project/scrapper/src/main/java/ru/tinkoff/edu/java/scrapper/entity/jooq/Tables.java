/*
 * This file is generated by jOOQ.
 */

package ru.tinkoff.edu.java.scrapper.entity.jooq;

import javax.annotation.processing.Generated;
import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.Link;
import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.Subscription;
import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.TgChat;

/**
 * Convenience access to all tables in the default schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Tables {

    /**
     * The table <code>LINK</code>.
     */
    public static final Link LINK = Link.LINK;

    /**
     * The table <code>SUBSCRIPTION</code>.
     */
    public static final Subscription SUBSCRIPTION = Subscription.SUBSCRIPTION;

    /**
     * The table <code>TG_CHAT</code>.
     */
    public static final TgChat TG_CHAT = TgChat.TG_CHAT;
}
