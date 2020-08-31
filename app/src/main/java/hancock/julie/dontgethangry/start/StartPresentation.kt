package hancock.julie.dontgethangry.start

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.airbnb.epoxy.EpoxyModel
import hancock.julie.dontgethangry.R

interface StartPresentation {
//    fun generateString(size: Int = 5): String

    fun generateEpoxyModelsForDecision(
        context: Context,
        isCreate: Boolean,
        coordinator: StartCoordination
    ): List<EpoxyModel<*>>

    fun generateEpoxyModelsForStart(context: Context, coordinator: StartCoordination): List<EpoxyModel<*>>
    fun generateEpoxyModelsForName(context: Context, coordinator: StartCoordination): List<EpoxyModel<*>>
}

class StartPresenter : StartPresentation {
    override fun generateEpoxyModelsForName(
        context: Context,
        coordinator: StartCoordination
    ): List<EpoxyModel<*>> {
        return listOf(
            createText(
                text = context.getString(R.string.whats_your_name),
                textType = TextType.Text5,
                center = false
            ),
            createEditText(
                hint = "Enter your name..."
            ),
            createCircleButton(
                icon = Icons.Next,
                location = Locations.BottomRight,
                clickListener = {
                    coordinator.launchStart(context)
                }
            )
        )
    }

    override fun generateEpoxyModelsForStart(context: Context, coordinator: StartCoordination): List<EpoxyModel<*>> {
        return listOf(
            createVerticalSpace(128),
            createBigButton(
                buttonText = context.getString(R.string.create_decision),
                clickListener = {
                    coordinator.launchCreateDecision(context)
                }
            ),
            createVerticalSpace(128),
            createBigButton(
                buttonText = context.getString(R.string.join_decision),
                clickListener = {
                    coordinator.launchJoinDecision(context)
                }
            ),
            createVerticalSpace(128),
            createBigButton(
                buttonText = context.getString(R.string.dine_alone),
                clickListener = {
                    coordinator.launchNext(context)
                }
            )
        )

    }

    override fun generateEpoxyModelsForDecision(
        context: Context,
        isCreate: Boolean,
        coordinator: StartCoordination
    ): List<EpoxyModel<*>> {
        val list = mutableListOf(
            createText(
                text = context.getString(R.string.decision_code),
                textType = TextType.Text4,
                center = true
            ),
            createDecisionCodeRow(
                edit = isCreate.not(),
                string = if(isCreate) generateString() else ""
            ),
            createText(
                text = if(isCreate) context.getString(R.string.share_code) else context.getString(R.string.ask_for_decision),
                textType = TextType.Subtext6,
                center = true
            ),
            createLine(),
            createText(
                text = context.getString(R.string.waiting_for_others),
                textType = TextType.Text5,
                center = true
            ),
//                createPersonRow(
//                    index = 0,
//                    name = "Emily"
//                ),
//                createPersonRow(
//                    index = 1,
//                    name = "Drew"
//                ),
//                createPersonRow(
//                    index = 2,
//                    name = "Julie"
//                ),
//                createLoader(),
            createVerticalSpace(64)
        )
        if(isCreate){
            list.add(
                createBigButton(
                    buttonText = context.getString(R.string.everyone_has_joined),
                    clickListener = {
                        coordinator.launchNext(context)
                    }
                )
            )
            list.add(createVerticalSpace(64))
            list.add(
                createBigButton(
                    buttonText = context.getString(R.string.join_decision_instead),
                    clickListener = {
                        coordinator.launchJoinDecision(context)
                        (context as Activity).finish()
                    }
                )
            )
        } else {
            list.add(
                createBigButton(
                    buttonText = context.getString(R.string.create_decision_instead),
                    clickListener = {
                        coordinator.launchCreateDecision(context)
                        (context as Activity).finish()
                    }
                )
            )
        }

        return list
    }

    private fun generateString(): String {
        return "AQTFY"
    }
}