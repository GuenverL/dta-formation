export const dtaToppings = {
        template:`
                    <li class="list-group-item btn" ng-repeat="topping in $ctrl.toppings track by $index" ng-click="$ctrl.click(topping)">
                        {{topping}}
                    </li>
            `,

        controller: function() {
            this.click = (topping) => {
                this.onSelect({
                    $event: topping
                })
            }
        },

        bindings: {
            onSelect: '&',
            toppings:'='
        }
}