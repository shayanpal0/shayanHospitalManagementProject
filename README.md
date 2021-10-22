# shayanHospitalManagementProject


This repository is based on Transaction in spring boot. Model class -> 4 -> Patient,Doctor,PatientAppointment,DoctorSchedule

==>Patient can registered independently
==>Doctors can be registered/deleted independent
==>PatientAppointment is related to Patient & Doctors as Patient should be registered before booking appointment and the specific doctor should be registed to it's database. And when the patienAppintment booking will be confirmend then both the patientAppontment & doctorSchedule work together.
==>when patient appointment is being booked then accordingly doctors schedule will also be booked and if the doctors schedule isn't free then the booking will not happen from both patient * doctors end.

Controller class-> Patient,Doctor,Appointment

==> Patient, Doctor controllers are doing the usual thing by controlling the operations on Patient & Doctors but the AppointmentController is only responsible for booking the appointment by engaging the time for both Patient & Doctor. And it's transactional.
