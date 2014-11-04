select * from AIP.CUSTOMER;
select * from AIP.ACCOUNT;

select * from AIP.ACTIVITY;
select * from AIP.JOYFLIGHT;
select * from AIP.PILOTTRAINING;
select * from AIP.TIMESLOT;

--populate customers
delete FROM AIP.CUSTOMER;
DELETE FROM AIP.ACCOUNT;

insert into AIP.ACCOUNT(ID,USERGROUP,DATEOFCREATION,PASSWORD,USERNAME) 
values (1,'CUSTOMER','1/1/2014','customer1','customer1');
INSERT INTO AIP.CUSTOMER(ID,EMAIL) VALUES (1,'customer1@gmail.com');





--populate joy flights
insert into AIP.ACTIVITY(id, activitytype, activitydesc, activitystate, aircraft, imageurl, price, provider, title)
values (1,'JOYFLIGHT','joy flight 1', 'AVAILABLE', 'f22', 'http://...', 20, 'provider 1', 'joy flight 1');
insert into AIP.JOYFLIGHT(ID, CAPACITY) VALUES(1,2);

insert into AIP.ACTIVITY(id, activitytype, activitydesc, activitystate, aircraft, imageurl, price, provider, title)
values (2,'JOYFLIGHT','joy flight 2', 'AVAILABLE', 'f35', 'http://...', 10, 'provider 2', 'joy flight 2');
insert into AIP.JOYFLIGHT(ID, CAPACITY) VALUES(2,1);

insert into AIP.TIMESLOT(ID,ENDDATE,ENDTIME,QUANTITY,STARTDATE,STARTTIME,STATUS,ACTIVITY_ID)
VALUES(1,'1/1/2014','13:00:00',10,'1/1/2014','10:00:00','AVAILABLE',1);
insert into AIP.TIMESLOT(ID,ENDDATE,ENDTIME,QUANTITY,STARTDATE,STARTTIME,STATUS,ACTIVITY_ID)
VALUES(2,'2/1/2014','13:00:00',10,'2/1/2014','10:00:00','AVAILABLE',1);


--populate pilot training
insert into AIP.ACTIVITY(id, activitytype, activitydesc, activitystate, aircraft, imageurl, price, provider, title)
values (3,'PILOTTRAINING','pilot training 1', 'AVAILABLE', 'A330', 'http://...', 20, 'provider 1', 'pilot training 1');
insert into AIP.PILOTTRAINING(ID, CERTIFICATE,DURATION) VALUES(3,'air bus certificate 1','3 months');

insert into AIP.ACTIVITY(id, activitytype, activitydesc, activitystate, aircraft, imageurl, price, provider, title)
values (4,'PILOTTRAINING','pilot training 2', 'AVAILABLE', 'A380', 'http://...', 10, 'provider 2', 'pilot training 2');
insert into AIP.PILOTTRAINING(ID, CERTIFICATE,DURATION) VALUES(4,'air bus certificate 2','6 months');


insert into AIP.TIMESLOT(ID,ENDDATE,ENDTIME,QUANTITY,STARTDATE,STARTTIME,STATUS,ACTIVITY_ID)
VALUES(3,'1/1/2014','13:00:00',10,'1/1/2014','10:00:00','AVAILABLE',3);
insert into AIP.TIMESLOT(ID,ENDDATE,ENDTIME,QUANTITY,STARTDATE,STARTTIME,STATUS,ACTIVITY_ID)
VALUES(4,'2/1/2014','13:00:00',10,'2/1/2014','10:00:00','AVAILABLE',3);