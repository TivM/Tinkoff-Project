/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.entity.jooq;


import jakarta.validation.constraints.NotNull;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.Link;
import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.Subscription;
import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.TgChat;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "https://www.jooq.org",
                "jOOQ version:3.17.6"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DefaultSchema extends SchemaImpl {

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();
    private static final long serialVersionUID = 1L;
    /**
     * The table <code>LINK</code>.
     */
    public final Link LINK = Link.LINK;

    /**
     * The table <code>SUBSCRIPTION</code>.
     */
    public final Subscription SUBSCRIPTION = Subscription.SUBSCRIPTION;

    /**
     * The table <code>TG_CHAT</code>.
     */
    public final TgChat TG_CHAT = TgChat.TG_CHAT;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    @NotNull
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    @NotNull
    public final List<Table<?>> getTables() {
        return Arrays.asList(
                Link.LINK,
                Subscription.SUBSCRIPTION,
                TgChat.TG_CHAT
        );
    }
}
