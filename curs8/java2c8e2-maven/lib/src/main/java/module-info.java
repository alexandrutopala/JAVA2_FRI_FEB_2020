open module lib {

    requires transitive java.rmi;
    requires com.google.gson;
    requires com.fasterxml.jackson.annotation;

    exports lib.model;
    exports lib.service;
    exports lib.event;
}