module lib {

    // modulele care vor avea o dependinta de lib,
    // tranzitiv, vor avea o dependinta si de
    // modulul java.rmi
    requires transitive java.rmi;

    exports lib.service;
    exports lib.event;
    exports lib.model;
}