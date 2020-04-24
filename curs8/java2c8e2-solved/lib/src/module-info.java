module lib {

    requires transitive java.rmi;

    exports lib.model;
    exports lib.service;
    exports lib.event;
}