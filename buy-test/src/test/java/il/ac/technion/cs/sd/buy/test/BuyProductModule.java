package il.ac.technion.cs.sd.buy.test;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import il.ac.technion.cs.sd.buy.app.BuyProductInitializer;
import il.ac.technion.cs.sd.buy.app.BuyProductInitializerImpl;
import il.ac.technion.cs.sd.buy.app.BuyProductReader;
import il.ac.technion.cs.sd.buy.app.BuyProductReaderImpl;
import il.ac.technion.cs.sd.buy.library.FutureStorage;
import il.ac.technion.cs.sd.buy.library.FutureStorageFactory;
import il.ac.technion.cs.sd.buy.library.FutureStringStorage;

// This module is in the testing project, so that it could easily bind all dependencies from all levels.
public class BuyProductModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(BuyProductInitializer.class).to(BuyProductInitializerImpl.class);
    bind(BuyProductReader.class).to(BuyProductReaderImpl.class);

    install(new FactoryModuleBuilder()
            .implement(FutureStorage.class, FutureStringStorage.class)
            .build(FutureStorageFactory.class));

    bind(String.class)
            .annotatedWith(Names.named("productsAndPricesFileName"))
            .toInstance("0");

    bind(String.class)
            .annotatedWith(Names.named("usersAndOrdersFileName"))
            .toInstance("1");

    bind(String.class)
            .annotatedWith(Names.named("ordersAndProductsFileName"))
            .toInstance("2");

    bind(String.class)
            .annotatedWith(Names.named("ordersAndHistoryFileName"))
            .toInstance("3");

    bind(String.class)
            .annotatedWith(Names.named("productsAndOrdersFileName"))
            .toInstance("4");

    bind(String.class)
            .annotatedWith(Names.named("usersAndProductsFileName"))
            .toInstance("5");

    bind(String.class)
            .annotatedWith(Names.named("productsAndUsersFileName"))
            .toInstance("6");

  }
}
