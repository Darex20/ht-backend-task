INSERT INTO public.time_period (end_date_time, start_date_time)
VALUES
    ('2023-06-01 10:00:00', '2023-06-02 10:00:00'),
    ('2023-06-02 11:00:00', '2023-06-03 11:00:00');

INSERT INTO public.customer_ref_type (description, href, "name")
VALUES
    ('Description 1', 'Href 1', 'Customer Ref Type 1'),
    ('Description 2', 'Href 2', 'Customer Ref Type 2');

INSERT INTO public.geo_code (geographic_datum, latitude, longitude)
VALUES
    ('Geographic Datum 1', 'Latitude 1', 'Longitude 1'),
    ('Geographic Datum 2', 'Latitude 2', 'Longitude 2');

INSERT INTO public.version_reference (href, "name", "version")
VALUES
    ('Href 1', 'Name 1', 'Version 1'),
    ('Href 2', 'Name 2', 'Version 2');

INSERT INTO public.point (x, y, z)
VALUES
    ('X 1', 'Y 1', 'Z 1'),
    ('X 2', 'Y 2', 'Z 2');

INSERT INTO public.time_period (end_date_time, start_date_time)
VALUES
    ('2023-06-01 10:00:00', '2023-06-02 10:00:00'),
    ('2023-06-02 11:00:00', '2023-06-03 11:00:00');

INSERT INTO public.geo_code (geographic_datum, latitude, longitude)
VALUES
    ('Geographic Datum 1', 'Latitude 1', 'Longitude 1'),
    ('Geographic Datum 2', 'Latitude 2', 'Longitude 2');

INSERT INTO public.version_reference (href, "name", "version")
VALUES
    ('Href 1', 'Name 1', 'Version 1'),
    ('Href 2', 'Name 2', 'Version 2');

INSERT INTO public.point (x, y, z)
VALUES
    ('X 1', 'Y 1', 'Z 1'),
    ('X 2', 'Y 2', 'Z 2');

INSERT INTO public.location (location_point_id, accuracy, geometry_type, href, "name", spatial_ref)
VALUES
    (1, 'Accuracy 1', 'Geometry Type 1', 'Href 1', 'Name 1', 'Spatial Ref 1'),
    (2, 'Accuracy 2', 'Geometry Type 2', 'Href 2', 'Name 2', 'Spatial Ref 2');

INSERT INTO public.address_role_reference ("role", address_role_time_period_id, href, "name")
VALUES
    (1, 1, 'Href 1', 'Role 1'),
    (2, 2, 'Href 2', 'Role 2');

INSERT INTO public.audit (created_date, change_reason, created_by, entity_version, source_system, source_system_user, span_id, tag_id)
VALUES
    ('2023-06-01 10:00:00', 'Change Reason 1', 'User 1', 'Version 1', 'System 1', 'System User 1', 'Span 1', 'Tag 1'),
    ('2023-06-02 11:00:00', 'Change Reason 2', 'User 2', 'Version 2', 'System 2', 'System User 2', 'Span 2', 'Tag 2');

INSERT INTO public.address (address_audit_id, address_geo_code_id, address_role_id, address_spec_ref_id, address_valid_for_id, city, country, full_address_name, href, locality, note, postcode, state_or_providence, street_name, street_nr, street_nr_last, street_nr_last_suffix, street_nr_suffix, street_suffix, street_type)
VALUES
    (1, 1, 1, 1, 1, 'City 1', 'Country 1', 'Full Address 1', 'Href 1', 'Locality 1', 'Note 1', '12345', 'State 1', 'Street Name 1', '10', '20', 'A', 'B', 'Suffix 1', 'Type 1'),
    (2, 2, 2, 2, 2, 'City 2', 'Country 2', 'Full Address 2', 'Href 2', 'Locality 2', 'Note 2', '67890', 'State 2', 'Street Name 2', '30', '40', 'C', 'D', 'Suffix 2', 'Type 2');

INSERT INTO public.sub_address (address_id, building_name, href, level_number, level_type, "name", private_street_name, private_street_number, sub_unit_number, sub_unit_type, "type")
VALUES
    (1, 'Building Name 1', 'Href 1', 'Level Number 1', 'Level Type 1', 'Name 1', 'Private Street Name 1', 'Private Street Number 1', 'Sub Unit Number 1', 'Sub Unit Type 1', 'Type 1'),
    (2, 'Building Name 2', 'Href 2', 'Level Number 2', 'Level Type 2', 'Name 2', 'Private Street Name 2', 'Private Street Number 2', 'Sub Unit Number 2', 'Sub Unit Type 2', 'Type 2');

INSERT INTO public.shipment_tracking (weight, create_date, estimated_delivery_date, shipment_tracking_address_from_id, shipment_tracking_address_to_id, shipment_tracking_related_customer_id, status_change_date, tracking_date, carrier, carrier_tracking_url, href, status, status_change_reason, tracking_code)
VALUES
    (10.5, '2023-06-01 10:00:00', '2023-06-05 12:00:00', 1, 2, 1, '2023-06-02 10:00:00', '2023-06-03 12:00:00', 'Carrier 1', 'Tracking URL 1', 'Href 1', 'Status 1', 'Change Reason 1', 'Tracking Code 1'),
    (15.2, '2023-06-02 11:00:00', '2023-06-06 13:00:00', 2, 1, 2, '2023-06-03 11:00:00', '2023-06-04 13:00:00', 'Carrier 2', 'Tracking URL 2', 'Href 2', 'Status 2', 'Change Reason 2', 'Tracking Code 2');

INSERT INTO public.checkpoint_type ("date", shipment_tracking_id, check_post, city, country, "message", state_or_province, status)
VALUES
    ('2023-06-01 10:00:00', 1, 'Check Post 1', 'City 1', 'Country 1', 'Message 1', 'State 1', 'Status 1'),
    ('2023-06-02 11:00:00', 2, 'Check Post 2', 'City 2', 'Country 2', 'Message 2', 'State 2', 'Status 2');

INSERT INTO public.order_ref_type (shipment_tracking_id, href, "name", reffered_type)
VALUES
    (1, 'Href 1', 'Name 1', 'Referred Type 1'),
    (2, 'Href 2', 'Name 2', 'Referred Type 2');


INSERT INTO public.error (is_title_enabled, retryable, severity, "timestamp", code, details, html_label, "label", "message", title)
VALUES
    (true, true, 1, '2023-06-01 10:00:00', 'Code 1', 'Details 1', 'HTML Label 1', 'Label 1', 'Message 1', 'Title 1'),
    (false, false, 2, '2023-06-02 11:00:00', 'Code 2', 'Details 2', 'HTML Label 2', 'Label 2', 'Message 2', 'Title 2');

INSERT INTO public.characteristic (address_id, audit_id, checkpoint_type_id, shipment_tracking_id, sub_address_id, "name", "value")
VALUES
    (1, 1, 1, 1, 1, 'Characteristic Name 1', 'Characteristic Value 1'),
    (2, 2, 2, 2, 2, 'Characteristic Name 2', 'Characteristic Value 2');
