/// <reference types="cypress" />

import Utils from '../util/util'
const utils = new Utils

import DashboardElement from '../elements/dashboardElement'
const dashboardElement = new DashboardElement;

export default class DashboardPage {

    validarTextoNaTela(text) {
        utils.validarText(dashboardElement.titleDashboard, text)
    }
}