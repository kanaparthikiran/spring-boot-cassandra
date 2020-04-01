CREATE KEYSPACE testkeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

CREATE TABLE IF NOT EXISTS  testkeyspace.hotels (id UUID,name varchar,address varchar,zip varchar,version int,primary key((id)));