/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2.Entitates;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faruk
 */
public class CustomerTab {

    //fields
    private SimpleStringProperty customer;
    private SimpleStringProperty projectNanme;
    private SimpleStringProperty inspectionPlace;
    private SimpleStringProperty inspectionStandart;
    private SimpleStringProperty evaluationStandart;
    private SimpleStringProperty inspectionProcedure;
    private SimpleStringProperty inspectionScope;
    private SimpleStringProperty drawingNo;
    private SimpleStringProperty surfaceCondition;
    private SimpleStringProperty stageOfExamination;
    private SimpleStringProperty page;
    private SimpleStringProperty reportNo;
    private SimpleStringProperty reportDate;
    private SimpleStringProperty jobOrderNo;
    private SimpleStringProperty offerNo;

//Constructor
    public CustomerTab() {

    }

    public CustomerTab(String customer, String projectName, String inspectionPlace, String inspectionStandart, String inspectionScope, String evaluationStandart, String inspectionProcedure, String drawingNo, String surfaceCondition,
            String stageOfExamination, String page, String reportNo, String reportDate, String jobOrderNo, String offerNo) {

        this.customer = new SimpleStringProperty(customer);
        this.projectNanme = new SimpleStringProperty(projectName);
        this.inspectionPlace = new SimpleStringProperty(inspectionPlace);
        this.inspectionStandart = new SimpleStringProperty(inspectionStandart);
        this.evaluationStandart = new SimpleStringProperty(evaluationStandart);
        this.inspectionProcedure = new SimpleStringProperty(inspectionProcedure);
        this.inspectionScope = new SimpleStringProperty(inspectionScope);
        this.drawingNo = new SimpleStringProperty(drawingNo);
        this.surfaceCondition = new SimpleStringProperty(surfaceCondition);
        this.stageOfExamination = new SimpleStringProperty(stageOfExamination);
        this.page = new SimpleStringProperty(page);
        this.reportNo = new SimpleStringProperty(reportNo);
        this.reportDate = new SimpleStringProperty(reportDate);
        this.jobOrderNo = new SimpleStringProperty(jobOrderNo);
        this.offerNo = new SimpleStringProperty(offerNo);

    }

    public String getCustomer() {
        return customer.getValue();
    }

    public void setCustomer(String customer) {
        this.customer.setValue(customer);
    }

    public String getProjectNanme() {
        return projectNanme.getValue();
    }

    public void setProjectNanme(String projectNanme) {
        this.projectNanme.setValue(projectNanme);
    }

    public String getInspectionPlace() {
        return inspectionPlace.getValue();
    }

    public void setInspectionPlace(String inspectionPlace) {
        this.inspectionPlace.setValue(inspectionPlace);
    }

    public String getInspectionStandart() {
        return inspectionStandart.getValue();
    }

    public void setInspectionStandart(String inspectionStandart) {
        this.inspectionStandart.getValue();
    }

    public String getEvaluationStandart() {
        return evaluationStandart.getValue();
    }

    public void setEvaluationStandart(String evaluationStandart) {
        this.evaluationStandart.setValue(evaluationStandart);
    }

    public String getInspectionProcedure() {
        return inspectionProcedure.getValue();
    }

    public void setInspectionProcedure(String inspectionProcedure) {
        this.inspectionProcedure.setValue(inspectionProcedure);
    }

    public String getInspectionScope() {
        return inspectionScope.getValue();
    }

    public void setInspectionScope(String inspectionScope) {
        this.inspectionScope.setValue(inspectionScope);
    }

    public String getDrawingNo() {
        return drawingNo.getValue();
    }

    public void setDrawingNo(String drawingNo) {
        this.drawingNo.setValue(drawingNo);
    }

    public String getSurfaceCondition() {
        return surfaceCondition.getValue();
    }

    public void setSurfaceCondition(String surfaceCondition) {
        this.surfaceCondition.setValue(surfaceCondition);
    }

    public String getStageOfExamination() {
        return stageOfExamination.getValue();
    }

    public void setStageOfExamination(String stageOfExamination) {
        this.stageOfExamination.setValue(stageOfExamination);
    }

    public String getPage() {
        return page.getValue();
    }

    public void setPage(String page) {
        this.page.setValue(page);
    }

    public String getReportNo() {
        return reportNo.getValue();
    }

    public void setReportNo(String reportNo) {
        this.reportNo.setValue(reportNo);
    }

    public String getReportDate() {
        return reportDate.getValue();
    }

    public void setReportDate(String reportDate) {
        this.reportDate.setValue(reportDate);
    }

    public String getJobOrderNo() {
        return jobOrderNo.getValue();
    }

    public void setJobOrderNo(String jobOrderNo) {
        this.jobOrderNo.set(jobOrderNo);
    }

    public String getOfferNo() {
        return offerNo.getValue();
    }

    public void setOfferNo(String offerNo) {
        this.offerNo.setValue(offerNo);
    }

}
