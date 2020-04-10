module A {
    // java.base - modulul principal al limbajului
    // este importat implicit
    // contine: java.lang, java.util, java.net

    requires java.base; // declaram ca modulul A are nevoie de modulul java.base

    exports service; // expun toate clasele publice din pachetul "service"
}